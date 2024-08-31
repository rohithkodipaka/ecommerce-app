package com.rohith.ecommerce.order;

import com.rohith.ecommerce.customer.CustomerClient;
import com.rohith.ecommerce.exception.BusinessException;
import com.rohith.ecommerce.kafka.OrderConfirmation;
import com.rohith.ecommerce.kafka.OrderProducer;
import com.rohith.ecommerce.orderline.OrderLineRequest;
import com.rohith.ecommerce.orderline.OrderLineService;
import com.rohith.ecommerce.payment.PaymentClient;
import com.rohith.ecommerce.payment.PaymentRequest;
import com.rohith.ecommerce.product.ProductClient;
import com.rohith.ecommerce.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerClient customerClient;

    private final ProductClient productClient;

    private final OrderMapper orderMapper;

    private final OrderLineService orderLineService;

    private final OrderProducer orderProducer;

    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest request) {
            //check the customer --> OpenFeign
            var customer = this.customerClient.findCustomerById(request.customerId())
                    .orElseThrow(()-> new BusinessException("Cannot create order:: No customer exist with the given id"));

            //purchase the product-->product microservice (Rest Template)
            var purchaseProducts = this.productClient.purchaseProducts(request.products());

            //persist order
            var order = this.orderRepository.save(orderMapper.toOrder(request));

            //persist order lines
            for(PurchaseRequest purchaseRequest: request.products()){
                orderLineService.saveOrderLine(
                        new OrderLineRequest(
                                null,
                                order.getId(),
                                purchaseRequest.productId(),
                                purchaseRequest.quantity()
                        )
                );
            }

            //todo start payment process
            var paymentRequest = new PaymentRequest(
                    request.amount(),
                    request.paymentMethod(),
                    order.getId(),
                    order.getReference(),
                    customer
            );
            paymentClient.requestOrderPayment(paymentRequest);

            //todo send the order confirmation -- notification-ms(kafka)
            orderProducer.sendOrderConfirmation(new OrderConfirmation(
                    request.reference(),
                    request.amount(),
                    request.paymentMethod(),
                    customer,
                    purchaseProducts
            ));
           return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(()->new EntityNotFoundException(String.format("No order found with the provided orderId:%d",orderId)));

    }
}

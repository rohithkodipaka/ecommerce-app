package com.rohith.ecommerce.order;

import com.rohith.ecommerce.customer.CustomerClient;
import com.rohith.ecommerce.exception.BusinessException;
import com.rohith.ecommerce.orderline.OrderLineRequest;
import com.rohith.ecommerce.orderline.OrderLineService;
import com.rohith.ecommerce.product.ProductClient;
import com.rohith.ecommerce.product.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerClient customerClient;

    private final ProductClient productClient;

    private final OrderMapper orderMapper;

    private final OrderLineService orderLineService;

    public Integer createOrder(OrderRequest request) {
            //check the customer --> OpenFeign
            var customer = this.customerClient.findCustomerById(request.customerId())
                    .orElseThrow(()-> new BusinessException("Cannot create order:: No customer exist with the given id"));

            //purchase the product-->product microservice (Rest Template)
            this.productClient.purchaseProducts(request.products());

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

            //todo send the order confirmation -- notification-ms(kafka)
           return null;
    }
}

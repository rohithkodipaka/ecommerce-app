package com.rohith.ecommerce.orderline;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    private OrderLineMapper orderLineMapper;

    public void saveOrderLine(OrderLineRequest orderLineRequest) {
        orderLineRepository.save(orderLineMapper.toOrderLine(orderLineRequest)).getId();
    }

    public List<OrderLineResponse> findByOrderId(Integer orderId) {
        return orderLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(orderLineMapper::fromOrderLine)
                .collect(Collectors.toList());
    }
}

package com.rohith.ecommerce.orderline;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    private OrderLineMapper orderLineMapper;

    public void saveOrderLine(OrderLineRequest orderLineRequest) {
        orderLineRepository.save(orderLineMapper.toOrderLine(orderLineRequest)).getId();
    }
}

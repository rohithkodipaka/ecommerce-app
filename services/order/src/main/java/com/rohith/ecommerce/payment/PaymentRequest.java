package com.rohith.ecommerce.payment;

import com.rohith.ecommerce.customer.CustomerResponse;
import com.rohith.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}

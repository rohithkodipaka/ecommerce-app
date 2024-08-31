package com.rohith.ecommerce.kafka;

import com.rohith.ecommerce.customer.CustomerResponse;
import com.rohith.ecommerce.order.PaymentMethod;
import com.rohith.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}

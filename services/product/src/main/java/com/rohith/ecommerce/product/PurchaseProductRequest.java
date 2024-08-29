package com.rohith.ecommerce.product;

import jakarta.validation.constraints.NotNull;

public record PurchaseProductRequest(

        @NotNull(message="Product id is mandatory")
        Integer id,

        @NotNull(message = "Quantity is mandatory")
        double quantity
) {
}

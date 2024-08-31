package com.rohith.ecommerce.payment;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String id,

        @NotNull(message="First Name cannot be null")
        String firstName,

        @NotNull(message = "last name cannot be null")
        String lastName,

        @Email(message = "Customer email is not valid")
        @NotNull(message = "Email is required")
        String email
) {
}

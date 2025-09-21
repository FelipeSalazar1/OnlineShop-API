package br.com.fiap.onlineshop.OnlineShop.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientUpdateData(
        @NotBlank
        Long id,

        String name,

        @Email
        String email,

        String documento
) {
}

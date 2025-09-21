package br.com.fiap.onlineshop.OnlineShop.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateData(
        String name,
        @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que 0")
        Float price,
        String category,
        String description,
        Boolean ativo
) {
}

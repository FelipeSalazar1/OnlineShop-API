package br.com.fiap.onlineshop.OnlineShop.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductUpdateData(
        String name,
        @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que 0")
        BigDecimal price,
        String category,
        String description,
        Boolean ativo
) {
}

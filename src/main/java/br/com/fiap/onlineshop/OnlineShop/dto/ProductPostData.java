package br.com.fiap.onlineshop.OnlineShop.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductPostData (

        @NotBlank
        String name,

        @Min(1)
        Float price,

        String category,

        String description,

        Boolean ativo
){
}

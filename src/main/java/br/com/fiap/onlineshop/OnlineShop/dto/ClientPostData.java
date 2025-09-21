package br.com.fiap.onlineshop.OnlineShop.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientPostData (

    @NotBlank
    String name,

    @NotBlank
    String documento,

    @Email
    String email
){
}


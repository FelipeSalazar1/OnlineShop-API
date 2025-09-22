package br.com.fiap.onlineshop.OnlineShop.dto;

import br.com.fiap.onlineshop.OnlineShop.model.Product;

import java.math.BigDecimal;

public record ProductGetData(Long id, String name, BigDecimal price, String category, String description, Boolean ativo) {
    public ProductGetData(Product product){
        this(product.getId(), product.getName(), product.getPrice(), product.getCategory(), product.getDescription(), product.getAtivo());
    }
}

package br.com.fiap.onlineshop.OnlineShop.dto;

import br.com.fiap.onlineshop.OnlineShop.model.Client;

public record ClientGetData(Long id, String name, String documento, String email) {
    public ClientGetData(Client client){
        this(client.getId(), client.getName(), client.getDocumento(), client.getEmail());
    }
}

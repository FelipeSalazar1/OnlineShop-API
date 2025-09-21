package br.com.fiap.onlineshop.OnlineShop.repository;

import br.com.fiap.onlineshop.OnlineShop.model.Client;
import br.com.fiap.onlineshop.OnlineShop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategotyOrAtivo(String category, Boolean ativo, Pageable pageable);
}
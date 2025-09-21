package br.com.fiap.onlineshop.OnlineShop.repository;

import br.com.fiap.onlineshop.OnlineShop.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByEmail(String email);

    Page<Client> findByNameOrEmail(String name, String email, Pageable pageable);
}
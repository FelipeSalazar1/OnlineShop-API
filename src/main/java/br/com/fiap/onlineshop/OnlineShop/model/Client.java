package br.com.fiap.onlineshop.OnlineShop.model;

import br.com.fiap.onlineshop.OnlineShop.dto.ClientPostData;
import br.com.fiap.onlineshop.OnlineShop.dto.ClientUpdateData;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Client")
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "documento", nullable = false, length = 30)
    private String documento;

    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;

    public Client(@Valid ClientPostData data) {
        this.name = data.name();
        this.documento = data.documento();
        this.email = data.email();
    }


    public void updateInfo(@Valid ClientUpdateData data) {
        if (data == null) {
            return;
        }
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.documento() != null) {
            this.documento = data.documento();
        }
        if (data.email() != null) {
            this.email = data.email();
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }
}


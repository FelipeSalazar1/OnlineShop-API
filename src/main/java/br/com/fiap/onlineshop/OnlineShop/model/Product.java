package br.com.fiap.onlineshop.OnlineShop.model;

import br.com.fiap.onlineshop.OnlineShop.dto.ProductPostData;
import br.com.fiap.onlineshop.OnlineShop.dto.ProductUpdateData;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "category", length = 60)
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    public Product(@Valid ProductPostData data) {
        this.name = data.name();
        this.price = data.price();
    }

    public void updateInfo(@Valid ProductUpdateData data) {
        if (data == null) {
            return;
        }
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.price().compareTo(BigDecimal.ZERO) > 0) {
            this.price = data.price();
        }
        if (data.category() != null) {
            this.category = data.category();
        }
        if(data.description() != null) {
            this.description = data.description();
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
package br.com.fiap.onlineshop.OnlineShop.service;

import br.com.fiap.onlineshop.OnlineShop.dto.*;
import br.com.fiap.onlineshop.OnlineShop.exception.ConflictException;
import br.com.fiap.onlineshop.OnlineShop.exception.ResourceNotFoundException;
import br.com.fiap.onlineshop.OnlineShop.model.Product;
import br.com.fiap.onlineshop.OnlineShop.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void create(ProductPostData data) {
        repository.save(new Product(data));
    }

    public void update(Long id, ProductUpdateData data) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        product.updateInfo(data);
        repository.save(product);
    }

    public List<Product> find() {
        return repository.findAll();
    }


    public ProductGetData findById(Long id) {
        return repository.findById(id).map(ProductGetData::new).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
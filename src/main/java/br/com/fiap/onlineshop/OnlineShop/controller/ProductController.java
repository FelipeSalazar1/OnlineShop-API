package br.com.fiap.onlineshop.OnlineShop.controller;

import br.com.fiap.onlineshop.OnlineShop.dto.ProductGetData;
import br.com.fiap.onlineshop.OnlineShop.dto.ProductPostData;
import br.com.fiap.onlineshop.OnlineShop.dto.ProductUpdateData;
import br.com.fiap.onlineshop.OnlineShop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> postProduct(@RequestBody @Valid ProductPostData data) {
        service.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductUpdateData data) {
        service.update(id, data);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<Page<ProductGetData>> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Boolean price,
            Pageable pageable) {
        Page<ProductGetData> result = service.find(name, price, pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductGetData> getProductById(@PathVariable Long id) {
        ProductGetData product = service.findById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

package br.com.fiap.onlineshop.OnlineShop.controller;

import br.com.fiap.onlineshop.OnlineShop.dto.ClientGetData;
import br.com.fiap.onlineshop.OnlineShop.dto.ClientPostData;
import br.com.fiap.onlineshop.OnlineShop.dto.ClientUpdateData;
import br.com.fiap.onlineshop.OnlineShop.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> postClient(@RequestBody @Valid ClientPostData data) {
        service.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClient(@PathVariable Long id, @RequestBody @Valid ClientUpdateData data) {
        service.update(id, data);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<Page<ClientGetData>> getClients(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            Pageable pageable) {
        Page<ClientGetData> result = service.find(name, email, pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientGetData> getClientById(@PathVariable Long id) {
        ClientGetData client = service.findById(id);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

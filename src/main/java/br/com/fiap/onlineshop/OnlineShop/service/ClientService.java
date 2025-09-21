package br.com.fiap.onlineshop.OnlineShop.service;

import br.com.fiap.onlineshop.OnlineShop.dto.ClientGetData;
import br.com.fiap.onlineshop.OnlineShop.dto.ClientPostData;
import br.com.fiap.onlineshop.OnlineShop.dto.ClientUpdateData;
import br.com.fiap.onlineshop.OnlineShop.exception.ConflictException;
import br.com.fiap.onlineshop.OnlineShop.exception.ResourceNotFoundException;
import br.com.fiap.onlineshop.OnlineShop.model.Client;
import br.com.fiap.onlineshop.OnlineShop.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void create(ClientPostData data) {
        if (repository.existsByEmail(data.email())) {
            throw new ConflictException("Email already in use" + data.email());
        }
        repository.save(new Client(data));
    }

    @Transactional
    public void update(Long id, ClientUpdateData data) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
        if (data.email() != null && !data.email().equals(client.getEmail())) {
            if (repository.existsByEmail(data.email())) {
                throw new ConflictException("Email already in use: " + data.email());
            }
        }

        client.updateInfo(data);
        repository.save(client);
    }

    public Page<ClientGetData> find(String name, String email, Pageable pageable) {
        if (name != null || email != null) {
            return repository.findByNameOrEmail(name, email, pageable).map(ClientGetData::new);
        }
        return repository.findAll(pageable).map(ClientGetData::new);
    }

    public ClientGetData findById(Long id) {
        return repository.findById(id).map(ClientGetData::new).orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Client not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

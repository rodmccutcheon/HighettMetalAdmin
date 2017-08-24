package com.highettmetal.services;

import com.highettmetal.domain.Client;
import com.highettmetal.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rodmccutcheon on 13/7/17.
 */
@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> listAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(id);
    }

    @Override
    public Client authenticateClient(String username, String password) {
        Client client = clientRepository.findByUsername(username);
        if (client != null) {
            if (client.getPassword().equals(password)) {
                return client;
            }
        }
        return null;
    }
}

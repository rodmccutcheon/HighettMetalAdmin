package com.highettmetal.services;

import com.highettmetal.domain.Client;

import java.util.List;

/**
 * Created by rodmccutcheon on 12/7/17.
 */
public interface ClientService {
    List<Client> listAllClients();

    Client getClientById(Long id);

    Client saveClient(Client client);

    void deleteClient(Long id);

    Client authenticateClient(String username, String password);
}

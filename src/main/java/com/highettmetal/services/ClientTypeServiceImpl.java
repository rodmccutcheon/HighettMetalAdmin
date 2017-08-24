package com.highettmetal.services;

import com.highettmetal.domain.ClientType;
import com.highettmetal.repositories.ClientTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rodmccutcheon on 24/7/17.
 */
@Service
public class ClientTypeServiceImpl implements ClientTypeService {

    private ClientTypeRepository clientTypeRepository;

    @Autowired
    public ClientTypeServiceImpl(ClientTypeRepository clientTypeRepository) {
        this.clientTypeRepository = clientTypeRepository;
    }

    @Override
    public List<ClientType> listAllClientTypes() {
        return clientTypeRepository.findAll();
    }

    @Override
    public ClientType getClientTypeById(Long id) {
        return clientTypeRepository.findOne(id);
    }

    @Override
    public ClientType saveClientType(ClientType clientType) {
        return clientTypeRepository.save(clientType);
    }

    @Override
    public void deleteClientType(Long id) {
        clientTypeRepository.delete(id);
    }
}
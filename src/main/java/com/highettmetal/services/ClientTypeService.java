package com.highettmetal.services;

import com.highettmetal.domain.ClientType;

import java.util.List;

/**
 * Created by rodmccutcheon on 24/7/17.
 */
public interface ClientTypeService {
    List<ClientType> listAllClientTypes();

    ClientType getClientTypeById(Long id);

    ClientType saveClientType(ClientType clientType);

    void deleteClientType(Long id);
}

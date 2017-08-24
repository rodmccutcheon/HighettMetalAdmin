package com.highettmetal.repositories;

import com.highettmetal.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rodmccutcheon on 12/7/17.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByUsername(String username);
}

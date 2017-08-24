package com.highettmetal.repositories;

import com.highettmetal.domain.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rodmccutcheon on 24/7/17.
 */
public interface ClientTypeRepository extends JpaRepository<ClientType, Long> {
}

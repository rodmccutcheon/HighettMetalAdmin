package com.highettmetal.repositories;

import com.highettmetal.domain.BinType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rodmccutcheon on 17/7/17.
 */
public interface BinTypeRepository extends JpaRepository<BinType, Long> {
}

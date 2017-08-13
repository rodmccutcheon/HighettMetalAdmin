package com.highettmetal.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by rodmccutcheon on 12/7/17.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.highettmetal.domain"})
@EnableJpaRepositories(basePackages = {"com.highettmetal.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}

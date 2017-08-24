package com.highettmetal.repositories;

import com.highettmetal.domain.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ClientRepository clientRepository;

    private Client client;

    @Before
    public void setUp() throws Exception {
        client = new Client();
        client.setUsername("nathanfake");
        testEntityManager.persist(client);
    }

    @Test
    public void findByUsernameWhenValidUsernameShouldReturnClient() throws Exception {
        Client found = clientRepository.findByUsername("nathanfake");
        assertThat(found.getUsername()).isEqualTo("nathanfake");
    }

    @Test
    public void findByUsernameWhenInvalidUsernameShouldReturnNull() throws Exception {
        Client found = clientRepository.findByUsername("doesntexist");
        assertThat(found).isNull();
    }
}

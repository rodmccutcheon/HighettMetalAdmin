package com.highettmetal.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BinTypeTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void createWhenBinNameIsNullShouldThrowException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Bin name must not be empty");
    }

    @Test
    public void saveShouldPersistData() throws Exception {
        BinType binType = this.testEntityManager.persistFlushFind(new BinType("Type 211", "1000mm x 1000mm x 1850mm"));
        assertThat(binType.getName()).isEqualTo("Type 211");
        assertThat(binType.getSize()).isEqualTo("1000mm x 1000mm x 1850mm");
    }
}

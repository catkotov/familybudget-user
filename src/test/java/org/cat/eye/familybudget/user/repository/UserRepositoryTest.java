package org.cat.eye.familybudget.user.repository;

import org.cat.eye.familybudget.user.model.FamilyBudgetUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        FamilyBudgetUser expectedUser = new FamilyBudgetUser();
        expectedUser.setNicName("first");
        expectedUser.setPassword("bla-bla-bla");
        repository.save(expectedUser);

        FamilyBudgetUser user = repository.findById("first").orElseGet(FamilyBudgetUser::new);
        assertEquals("first", user.getNicName());
        assertEquals("bla-bla-bla", user.getPassword());
    }

}
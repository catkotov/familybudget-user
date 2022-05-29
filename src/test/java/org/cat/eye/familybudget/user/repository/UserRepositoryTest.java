package org.cat.eye.familybudget.user.repository;

import org.cat.eye.familybudget.user.model.FamilyBudgetUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @BeforeEach
    void init() {

    }

    @AfterEach
    void clean() {
        repository.deleteAll();
    }

    @Test
    void saveAndFindById() {
        FamilyBudgetUser expectedUser = new FamilyBudgetUser();
        expectedUser.setNicName("first");
        expectedUser.setPassword("bla-bla-bla");
        repository.save(expectedUser);

        FamilyBudgetUser user = repository.findById("first").orElseGet(FamilyBudgetUser::new);
        assertEquals("first", user.getNicName());
        assertEquals("bla-bla-bla", user.getPassword());
    }

    @Test
    void saveAllAndFindAll() {

        List<FamilyBudgetUser> users = new LinkedList<>();

        FamilyBudgetUser user_1 = new FamilyBudgetUser();
        user_1.setNicName("first");
        user_1.setPassword("bla-bla-bla");
        users.add(user_1);
        FamilyBudgetUser user_2 = new FamilyBudgetUser();
        user_2.setNicName("second");
        user_2.setPassword("blu-blu-blu");
        users.add(user_2);

        repository.saveAll(users);

        List<FamilyBudgetUser> userList = (List<FamilyBudgetUser>) repository.findAll();

        assertEquals(2, userList.size());
        assertEquals(2, repository.count());
    }

}
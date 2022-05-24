package org.cat.eye.familybudget.user.controller;

import org.cat.eye.familybudget.user.model.FamilyBudgetUser;
import org.cat.eye.familybudget.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(FamilyBudgetUserController.class)
class FamilyBudgetUserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository repository;

    @Test
    void getUser() throws Exception {

        FamilyBudgetUser user = new FamilyBudgetUser();
        user.setNicName("nic-nic");
        user.setPassword("naf-naf");

        given(repository.findById("nic-nic")).willReturn(Optional.of(user));

        mvc.perform(get("/familybudget/user/nic-nic").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nicName", is(user.getNicName())))
                .andExpect(jsonPath("$.password", is(user.getPassword())));
    }


}
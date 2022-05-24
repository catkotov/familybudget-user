package org.cat.eye.familybudget.user.controller;

import org.cat.eye.familybudget.user.model.FamilyBudgetUser;
import org.cat.eye.familybudget.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/familybudget/user")
public class FamilyBudgetUserController {

    UserRepository repository;

    @Autowired
    public FamilyBudgetUserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{nicName}")
    public FamilyBudgetUser getUser(@PathVariable String nicName) {

        FamilyBudgetUser user = repository.findById(nicName).orElseGet(() -> null);
        return user;
    }

}

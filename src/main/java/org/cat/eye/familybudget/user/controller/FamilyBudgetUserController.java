package org.cat.eye.familybudget.user.controller;

import org.cat.eye.familybudget.user.model.FamilyBudgetUser;
import org.cat.eye.familybudget.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return repository.findById(nicName).orElseGet(() -> null);
    }

    @PostMapping("/{nicName}/{password}")
    public void addUser(@PathVariable String nicName, @PathVariable String password) {
        FamilyBudgetUser user = new FamilyBudgetUser();
        user.setNicName(nicName);
        user.setPassword(password);
        repository.save(user);
    }

}

package org.cat.eye.familybudget.user.repository;

import org.cat.eye.familybudget.user.model.FamilyBudgetUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<FamilyBudgetUser, String> {

}

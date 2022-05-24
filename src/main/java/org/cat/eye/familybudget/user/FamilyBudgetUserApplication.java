package org.cat.eye.familybudget.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class})
public class FamilyBudgetUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyBudgetUserApplication.class, args);
    }

}

package org.cat.eye.familybudget.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "familybudgetuser")
public class FamilyBudgetUser {

    @Id
    @Column(name = "nicname")
    private String nicName;

    private String password;

    public String getNicName() {
        return nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyBudgetUser that = (FamilyBudgetUser) o;
        return nicName.equals(that.nicName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nicName);
    }

}

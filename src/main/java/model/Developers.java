package model;

import java.util.List;
import java.util.Set;

public class Developers extends BaseEntity {
private String name;
Accounts accounts;
Set<Skills> skills;

    public Developers(Long id, String name, Accounts accounts, Set<Skills> skills) {
        super(id);
        this.name = name;
        this.accounts = accounts;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }
}

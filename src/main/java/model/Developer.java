package model;


import java.util.Set;

public class Developer {
    private Long id;
    private String name;
    private Long salary;
    private Set<Skill> skills;
    private Account account;

    public Developer(String name, Long salary, Set<Skill> skills) {
        this.name = name;
        this.salary = salary;
        this.skills = skills;
    }

    public Developer(Long id, String name, Long salary, Set<Skill> skills, Account account) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.skills = skills;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", skills=" + getSkills() +
                ", account=" + account +
                '}';
    }
}
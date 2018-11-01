package model;


import java.util.Set;

public class Developers {
    private Long id;
    private String name;

    private Set<Skills> skills;

    public Developers(Long id, String name, Set<Skills> skills) {
        this.id = id;
        this.name = name;
        this.skills = skills;
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

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }
}
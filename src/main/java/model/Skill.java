package model;

public class Skill {
    private Long id;
   private String name;
   private Long developersId;

    public Skill(Long id, String name, Long developersId) {
        this.id = id;
        this.name = name;
        this.developersId = developersId;
    }

    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Skill(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developersId=" + developersId +
                '}';
    }
}

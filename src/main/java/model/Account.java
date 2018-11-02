package model;

public class Account {
    private Long id;
private String data;
private Long developerID;

    public Account(Long id, String data, Long developerID) {
        this.id = id;
        this.data = data;
        this.developerID = developerID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getDeveloperID() {
        return developerID;
    }

    public void setDeveloperID(Long developerID) {
        this.developerID = developerID;
    }
}

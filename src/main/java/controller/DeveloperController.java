package controller;

import model.Developer;
import service.DeveloperService;

import java.util.List;

public class DeveloperController {
    DeveloperService developerService;
    public DeveloperController(){
        developerService = new DeveloperService();
    }

    public void create(Developer developer) {
        developerService.create(developer);
    }

    public Developer getById(Long id) {
        return developerService.getById(id);
    }

    public void update(Developer developer) {
        developerService.update(developer);
    }

    public void delete(Long id) {
        developerService.delete(id);
    }

    public List<Developer> getAll() {
        return developerService.getAll();
    }
}

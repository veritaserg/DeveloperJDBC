package controller;

import model.Skill;
import service.SkillService;

import java.util.List;

public class SkillController {
    SkillService skillService;
    public SkillController(){
        skillService = new SkillService();
    }
    public void create(Skill skill) {
        skillService.create(skill);
    }

    public Skill getById(Long id) {
        return skillService.getById(id);
    }

    public void update(Skill skill) {
        skillService.update(skill);
    }

    public void delete(Long id) {
        skillService.delete(id);
    }

    public List<Skill> getAll() {
        return skillService.getAll();
    }
}

package view;

import controller.SkillController;
import model.Skill;

import java.util.List;

public class SkillView {
    SkillController skillController;
    public SkillView(){
        skillController = new SkillController();
    }
    public void getAll(){
        List<Skill> skills = skillController.getAll();
        if (skills.isEmpty()) {
            ConsoleHelper.writeToConsole("\nThere are no records to view.\n");
        } else {
            for (Skill skill : skills) {
                ConsoleHelper.writeToConsole("\n" + "ID = " + skill.getId().toString() + " || Skills: " + skill.getName());
            }
        }
    }
}

package view;

import controller.DeveloperController;
import model.Account;
import model.Developer;
import model.Skill;
import service.DeveloperService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeveloperView {
    DeveloperController developerController;
    SkillView skillView;

    public DeveloperView() {
        developerController = new DeveloperController();
        skillView = new SkillView();
    }

    public void create() {
        developerController.create(createDev(0));
    }

    public void getAll() {
        List<Developer> developers = developerController.getAll();
        if (developers.isEmpty()) {
            ConsoleHelper.writeToConsole("\nThere are no records to view.\n");
        } else {
            for (Developer dev : developers) {
                writeById(dev);
            }
        }
    }

    public void getById() {
        while (true) {
            ConsoleHelper.writeToConsole("Input ID:");
            try {
                Long id = Long.valueOf(Integer.parseInt(ConsoleHelper.readString()));
                writeById(developerController.getById(id));
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole("Wrong ID. Try again.\n");
            }
        }
    }

    private void writeById(Developer dev) {
        if (dev == null || (dev.getId() == 0 && dev.getName() == null)) {
            ConsoleHelper.writeToConsole("\nThere is no such ID\n");
        } else {
            ConsoleHelper.writeToConsole("\n" + "ID = " + dev.getId() +
                    " || Name: " + dev.getName() +
                    " || Salary: " + dev.getSalary() +
                    " || Skill:" + dev.getSkills() +
                    " || Account:  " + dev.getAccount());
        }
    }

    public void update() {
        ConsoleHelper.writeToConsole("Creating Developer for update ...");
        developerController.update(createDev(1));
    }

    public void delete() {
        while (true) {
            ConsoleHelper.writeToConsole("Input ID:");
            try {
                Long id = Long.valueOf(ConsoleHelper.readString());
                developerController.delete(id);
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole("Wrong ID. Try again.\n");
            }
        }


    }

    private Developer createDev(int i) {
        Developer developer;
        Long id = 0l;
        String devName;
        Long salary;
        Account account;
        Set<Skill> skills = new HashSet<>();

        if (i > 0) {
            while (true) {
                try {
                    ConsoleHelper.writeToConsole("Input ID");
                    id = Long.valueOf(ConsoleHelper.readString());
                    break;
                } catch (IOException e) {
                    ConsoleHelper.writeToConsole("Failed input. Try again");
                }
            }
        }
        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input Name Developer");
                devName = ConsoleHelper.readString();
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole("Failed input. Try again");
            }
        }
        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input Salary of Developer");
                salary = Long.valueOf(ConsoleHelper.readString());
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input Account of you repository");
                String acname = ConsoleHelper.readString();
                account = new Account(acname, id);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input skill's  of developer: (for finish input 'exit')");
                skillView.getAll();
                String str;
                ArrayList<Long> idSkills = new ArrayList<>();

                while (!(str = ConsoleHelper.readString()).equalsIgnoreCase("exit")) {
                    {
                        try {
                            idSkills.add(Long.valueOf(str));
                        } catch (NumberFormatException e) {
                            ConsoleHelper.writeToConsole("Wrong integer. Try again");
                        }
                    }
                }

                for (Long idSkill : idSkills) {
                    skills.add(new Skill(idSkill));
                }
                break;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Developer(id, devName, salary, skills, account);
    }


}

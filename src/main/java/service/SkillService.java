package service;

import dao.jdbc.JdbcSkillDAOImpl;
import model.Developer;
import model.Skill;

import java.util.List;

public class SkillService {
    JdbcSkillDAOImpl jdbcSkillDAO;
    public SkillService(){
        jdbcSkillDAO = new JdbcSkillDAOImpl();
    }
    public void create(Skill skill) {
jdbcSkillDAO.create(skill);
    }

    public Skill getById(Long id) {
        return jdbcSkillDAO.getById(id);
    }

    public void update(Skill skill) {
jdbcSkillDAO.update(skill);
    }

    public void delete(Long id) {
jdbcSkillDAO.delete(id);
    }

    public List<Skill> getAll() {
        return jdbcSkillDAO.getAll();
    }
}

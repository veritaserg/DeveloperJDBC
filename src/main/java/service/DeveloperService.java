package service;

import dao.jdbc.JdbcDeveloperDAOImpl;
import model.Developer;

import java.util.List;

public class DeveloperService {
    JdbcDeveloperDAOImpl jdbcDeveloperDAO;
    public DeveloperService(){
        jdbcDeveloperDAO = new JdbcDeveloperDAOImpl();
    }
    public void create(Developer developer) {
jdbcDeveloperDAO.create(developer);
    }

    public Developer getById(Long id) {
        return jdbcDeveloperDAO.getById(id);
    }

    public void update(Developer developer) {
jdbcDeveloperDAO.update(developer);
    }

    public void delete(Long id) {
jdbcDeveloperDAO.delete(id);
    }

    public List<Developer> getAll() {
        return jdbcDeveloperDAO.getAll();
    }
}

package dao.jdbc;

import dao.DeveloperDAO;
import dao.util.Util;
import model.Developer;
import model.Skill;

import java.sql.*;
import java.util.*;

public class JdbcDeveloperDAOImpl implements DeveloperDAO {
    public static void main(String[] args) {
        JdbcDeveloperDAOImpl jdbcDeveloperDAO = new JdbcDeveloperDAOImpl();
        Set<Skill> skills = new HashSet<>();
        skills.add(new Skill((long) 1, "qwqw"));
        skills.add(new Skill((long) 2, "qwqw"));
        Developer developer = new Developer("Petrovich", 3333L, skills);

       // jdbcDeveloperDAO.create(developer);
        jdbcDeveloperDAO.delete(13l);


    }

    public void create(Developer developer) {
        String SQL = "INSERT INTO developers(name,salary) VALUES(?,?)";
        String GET_LAST_INSERTED = "SELECT LAST_INSERT_ID()";
        Connection connection = null;
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);

            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setString(1, developer.getName());
                statement.setLong(2, developer.getSalary());
                statement.executeUpdate();
            }
            long id;
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID()");
                resultSet.next();
                id = resultSet.getLong(1);
            }
            try (PreparedStatement statement = connection.prepareStatement("INSERT developers_skills VALUES (?,?)")) {
                for (Skill skill : developer.getSkills()) {
                    statement.setLong(1, id);
                    statement.setLong(2, skill.getId());
                    statement.addBatch();
                }
                statement.executeBatch();
                connection.commit();
            } finally {
                Util.disconnect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Developer getById(Long id) {
        return null;
    }

    public void update(Developer developer) {

    }

    public void delete(Long id) {
        String SQL = "DELETE FROM developers WHERE ID = ?";
String DELETE_SKILLS = "DELETE FROM developers_skills WHERE ID = ?";
        Connection connection = null;
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setLong(1, id);
                statement.executeUpdate();
            }
            try (PreparedStatement statement = connection.prepareStatement(DELETE_SKILLS)) {
                statement.setLong(1, id);
                statement.executeUpdate();
            }
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.disconnect();
        }
    }

    public List<Developer> getAll() {
        return null;
    }
}

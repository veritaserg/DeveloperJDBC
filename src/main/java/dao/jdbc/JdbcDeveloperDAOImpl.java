package dao.jdbc;

import dao.DeveloperDAO;
import dao.util.Util;
import model.Account;
import model.Developer;
import model.Skill;

import java.sql.*;
import java.util.*;

public class JdbcDeveloperDAOImpl implements DeveloperDAO {
    JdbcAccountDAOImpl jdbcAccountDAO;
    JdbcSkillDAOImpl jdbcSkillDAO;
    Connection connection;

    public JdbcDeveloperDAOImpl() {
        jdbcAccountDAO = new JdbcAccountDAOImpl();
        jdbcSkillDAO = new JdbcSkillDAOImpl();
    }

    public void create(Developer developer) {
        long id;
        String SQL = "INSERT INTO developers(name,salary) VALUES(?,?)";

        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setString(1, developer.getName());
                statement.setLong(2, developer.getSalary());
                statement.executeUpdate();
            }
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID()");
                resultSet.next();
                id = resultSet.getLong(1);
                Account account = developer.getAccount();
                account.setId(id);
                jdbcAccountDAO.create(account);
            }
            try (PreparedStatement statement = connection.prepareStatement("INSERT developers_skills VALUES (?,?)")) {
                for (Skill skill : developer.getSkills()) {
                    statement.setLong(1, id);
                    statement.setLong(2, skill.getId());
                    statement.addBatch();
                }
                statement.executeBatch();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.disconnect();
        }
    }

    public Developer getById(Long id) {
        Developer developer = null;
        String SQL = "SELECT * FROM developers WHERE id = ?";
        try {
            connection = Util.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setLong(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    Long salary = resultSet.getLong("salary");
                    Set<Skill> skills = jdbcSkillDAO.getSkillById(id);
                    Account account = jdbcAccountDAO.getById(id);
                    developer = new Developer(id, name, salary, skills, account);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.disconnect();
        }

        return developer;
    }

    public void update(Developer developer) {
        String SQL = "UPDATE developers SET name = ?,salary =? WHERE ID = ?";
        String DELETE_SKILLS = "DELETE FROM developers_skills WHERE developers_id = ?";

        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setString(1, developer.getName());
                statement.setLong(2, developer.getSalary());
                statement.setLong(3, developer.getId());
                statement.executeUpdate();
            }
            try (PreparedStatement statement = connection.prepareStatement(DELETE_SKILLS)) {
                statement.setLong(1, developer.getId());
                statement.executeUpdate();
            }
            try (PreparedStatement statement = connection.prepareStatement("INSERT developers_skills VALUES (?,?)")) {
                for (Skill skill : developer.getSkills()) {
                    statement.setLong(1, developer.getId());
                    statement.setLong(2, skill.getId());
                    statement.addBatch();
                }
                statement.executeBatch();
            }
            connection.commit();

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            Util.disconnect();

        }
        jdbcAccountDAO.update(developer.getAccount());
    }

    public void delete(Long id) {
        String SQL = "DELETE FROM developers WHERE ID = ?";
        String DELETE_SKILLS = "DELETE FROM developers_skills WHERE developers_id = ?";
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
        jdbcAccountDAO.delete(id);
    }

    public List<Developer> getAll() {
        List<Developer> developers = new ArrayList<>();
        String SQL = "SELECT * FROM developers";
        try {
            connection = Util.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Long developerId = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    Long salary = resultSet.getLong("salary");
                    Set<Skill> skills = jdbcSkillDAO.getSkillById(developerId);
                    Account account = jdbcAccountDAO.getById(developerId);

                    developers.add(new Developer(developerId, name, salary, skills, account));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developers;
    }

}

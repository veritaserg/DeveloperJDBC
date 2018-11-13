package dao.jdbc;

import dao.SkillDAO;
import dao.util.Util;
import dao.util.UtilAws;
import model.Account;
import model.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JdbcSkillDAOImpl implements SkillDAO {
    Connection connection;

    public void create(Skill skill) {
        String SQL = "INSERT INTO dev.skills(name) VALUES(?)";
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setString(1,skill.getName());
                                statement.executeUpdate();
                               connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.disconnect();
        }

    }

    public Skill getById(Long id) {
        return null;
    }

    public Set<Skill> getSkillById(Long id) {
        Set<Skill> skills = new HashSet<>();
        String SQL = "SELECT *\n" +
                "         FROM skills\n" +
                "             INNER JOIN developers_skills ON skills_id = skills.id\n" +
                "         WHERE developers_id = ?";
        try {
            connection = Util.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setLong(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Long skillIId = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    Long developersID = resultSet.getLong("developers_id");
                    skills.add(new Skill(skillIId, name, developersID));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.disconnect();

        }
        return skills;
    }


    public void update(Skill skill) {
    }

    public void delete(Long id) {
    }

    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();
        String SQL = "SELECT * FROM skills";
        try {
            connection = UtilAws.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Long skillId = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    skills.add(new Skill(skillId, name));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return skills;
    }
}


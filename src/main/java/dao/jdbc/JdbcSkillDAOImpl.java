package dao.jdbc;

import dao.SkillDAO;
import dao.util.Util;
import model.Account;
import model.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcSkillDAOImpl implements SkillDAO {
    public void create(Skill skill) {

    }

    public Skill getById(Long id) {
        return null;
    }

    public void update(Skill skill) {

    }

    public void delete(Long id) {

    }

    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();
        String SQL = "SELECT * FROM skills";
        Connection connection;
        try {
            connection = Util.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Long skillId = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                   skills.add(new Skill(skillId,name));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.disconnect();
        }return skills;
    }
    }


package dao.jdbc;

import dao.AccountDAO;
import dao.util.Util;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JdbcAccountDAOImpl implements AccountDAO {
    public static void main(String[] args) {
        JdbcAccountDAOImpl jdbcAccountDAO = new JdbcAccountDAOImpl();
        Account account = new Account("xx", (long)44);
   jdbcAccountDAO.update(account);
        System.out.println(account.getDeveloperID());


    }

    public void create(Account account) {
        String SQL = "INSERT INTO accounts(name,developer_id) VALUES(?,?)";
        Connection connection = null;
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setString(1, account.getData());
                statement.setLong(2, account.getId());
                              statement.executeUpdate();
                            connection.commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Util.disconnect();
        }
    }
        public Account getById(Long id) {
        return null;
    }

    public void update(Account account) {
        Connection connection = null;

        String SQL = "UPDATE accounts SET name = ?,developer_id = ? WHERE developer_id = ?";
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setLong(3, account.getDeveloperID());
                statement.setString(1, account.getData());
                statement.setLong(2, account.getDeveloperID());
             statement.executeUpdate();
             connection.commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.disconnect();
        }
        }

    public void delete(Long id) {
        String SQL = "DELETE FROM accounts WHERE developer_id = ?";
        Connection connection = null;
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(SQL)) {
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

    public List<Account> getAll() {
        return null;
    }
}

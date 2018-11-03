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
        Account account = new Account((long) 1,"qwer", (long)4);
        jdbcAccountDAO.delete(2l);
        jdbcAccountDAO.delete(3l);


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

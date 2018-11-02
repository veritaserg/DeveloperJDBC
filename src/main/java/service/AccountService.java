package service;

import dao.jdbc.JdbcAccountDAOImpl;
import model.Account;
import model.Developer;

import java.util.List;

public class AccountService {
    JdbcAccountDAOImpl jdbcAccountDAO;
    public void create(Account account) {
jdbcAccountDAO.create(account);
    }

    public Account getById(Long id) {
        return jdbcAccountDAO.getById(id);
    }

    public void update(Account account) {
jdbcAccountDAO.update(account);
    }

    public void delete(Long id) {
jdbcAccountDAO.delete(id);
    }

    public List<Account> getAll() {
        return jdbcAccountDAO.getAll();
    }
}

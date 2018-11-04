package controller;

import model.Account;
import service.AccountService;

import java.util.List;

public class AccountController {
    AccountService accountService;
    public AccountController(){
        accountService = new AccountService();
    }
    public void create(Account account) {
        accountService.create(account);
    }

    public Account getById(Long id) {
        return accountService.getById(id);
    }

    public void update(Account account) {
        accountService.update(account);
    }

    public void delete(Long id) {
        accountService.delete(id);
    }

    public List<Account> getAll() {
        return accountService.getAll();
    }
}

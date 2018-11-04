package view;

import controller.AccountController;
import model.Account;

import java.util.List;

public class AccountView {
    AccountController accountController;

    public AccountView() {
        accountController = new AccountController();
    }

    public void getAll() {
        List<Account> accounts = accountController.getAll();
        if (accounts.isEmpty()) {
            ConsoleHelper.writeToConsole("\nThere are no records to view.\n");
        } else {
            for (Account account : accounts) {
                ConsoleHelper.writeToConsole("\n" + "ID = " + account.getDeveloperID() + " || Account: " + account.getData());
            }
        }
    }
}

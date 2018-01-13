package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.command.account.AddAccountCommand;
import project.command.account.DeleteAccountCommand;
import project.command.account.UpdateAccountCommand;

/**
 * @author Egor Stepanov
 * @since 13-01-2018.
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AddAccountCommand addAccountCommand;

    @Autowired
    private DeleteAccountCommand deleteAccountCommand;

    @Autowired
    private UpdateAccountCommand updateAccountCommand;
}

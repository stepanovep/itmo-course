package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import project.command.CommandResponse;
import project.command.account.AddAccountCommand;
import project.command.account.DeleteAccountCommand;
import project.command.account.UpdateAccountCommand;
import project.command.account.model.AddAccountRequest;
import project.command.account.model.AddAccountResponse;
import project.command.account.model.DeleteAccountRequest;
import project.command.account.model.UpdateAccountRequest;
import project.engine.executor.ProjectCommandExecutor;

/**
 * Контроллер для команд работающий с аккаунтом
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@RestController
@RequestMapping(
        value = "/account",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class AccountController {

    @Autowired
    private AddAccountCommand addAccountCommand;

    @Autowired
    private DeleteAccountCommand deleteAccountCommand;

    @Autowired
    private UpdateAccountCommand updateAccountCommand;

    @Autowired
    private ProjectCommandExecutor accountCommandExecutor;

    @PostMapping(value = "/add")
    public DeferredResult<ResponseEntity<CommandResponse<AddAccountResponse>>> add(@RequestBody AddAccountRequest request) {
        return accountCommandExecutor.executeCommand(addAccountCommand, request);
    }

    @PostMapping(value = "/delete")
    public DeferredResult<ResponseEntity<CommandResponse<Void>>> delete(@RequestBody DeleteAccountRequest request) {
        return accountCommandExecutor.executeCommand(deleteAccountCommand, request);
    }

    @PostMapping(value = "/update")
    public DeferredResult<ResponseEntity<CommandResponse<Void>>> update(@RequestBody UpdateAccountRequest request) {
        return accountCommandExecutor.executeCommand(updateAccountCommand, request);
    }
}

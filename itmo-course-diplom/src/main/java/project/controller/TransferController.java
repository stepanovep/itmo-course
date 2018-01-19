package project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import project.command.CommandResponse;
import project.command.transfer.TransferCommand;
import project.command.transfer.TransferRequest;
import project.command.transfer.TransferResponse;
import project.engine.executor.ProjectCommandExecutor;
import project.entity.Account;
import project.repository.AccountRepository;

/**
 * Контроллер для команд работающих с переводами
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@RestController
@RequestMapping(
        value = "/",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class TransferController {

    private static final Logger log = LoggerFactory.getLogger(TransferController.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransferCommand transferCommand;

    @Autowired
    private ProjectCommandExecutor transferCommandExecutor;

    @GetMapping(value = "get")
    public String save() {
        accountRepository.save(new Account("testSave", "blah@sdf.sd"));
        log.info("new account saved into repository");
        return "get - OK";
    }

    @PostMapping(value = "transfer")
    public DeferredResult<ResponseEntity<CommandResponse<TransferResponse>>> transfer(@RequestBody TransferRequest request) {
        log.info("request={}", request);
        return transferCommandExecutor.executeCommand(transferCommand, request);
    }
}

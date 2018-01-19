package project.engine.fsm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.command.transfer.TransferRequest;
import project.entity.Account;
import project.entity.Transaction;
import project.repository.AccountRepository;
import project.repository.TransactionRepository;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Egor Stepanov
 * @since 18-01-2018.
 */
@Component
public class TransferProcessExecutor implements ProcessExecutor<Process<TransferContext>> {

    private static final Logger log = LoggerFactory.getLogger(TransferProcessExecutor.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Nonnull
    @Override
    public ProcessType getProcessType() {
        return ProcessType.TRANSFER;
    }

    @Override
    public void execute(@Nonnull Process<TransferContext> process) {
        Objects.requireNonNull(process, "process");
        TransferContext ctx = process.getProcessCtx();
        TransferRequest request = ctx.getRequest();

        Account accountFrom = accountRepository.findOne(request.getAccountIdFrom());
        Account accountTo = accountRepository.findOne(request.getAccountIdTo());

        if (ctx.getStage() == TransferStage.VALIDATE_CONTEXT) {
            log.info("Executing stage: {}", ctx.getStage());

            if (accountFrom == null || accountTo == null) {
                ctx.setErrorMessage("Both accounts must be present!");
                ctx.setStage(TransferStage.FAILED);
                return;
            }

            if (accountFrom.getBalance() < request.getAmount()) {
                ctx.setErrorMessage("Not enough funds to transfer");
                ctx.setStage(TransferStage.FAILED);
                return;
            }

            ctx.setStage(TransferStage.TRANFSER_PAYER_TO_GATE);
        }

        if (ctx.getStage() == TransferStage.TRANFSER_PAYER_TO_GATE) {
            log.info("Executing stage: {}", ctx.getStage());

            accountFrom.withdraw(request.getAmount());
            accountRepository.save(accountFrom);
            ctx.setStage(TransferStage.TRANSFER_GATE_TO_RECIPIENT);
        }

        if (ctx.getStage() == TransferStage.TRANSFER_GATE_TO_RECIPIENT) {
            log.info("Executing stage: {}", ctx.getStage());

            accountTo.deposit(request.getAmount());
            accountRepository.save(accountTo);
            ctx.setStage(TransferStage.INSERT_TRANSACTION);
        }

        if (ctx.getStage() == TransferStage.INSERT_TRANSACTION) {
            log.info("Executing stage: {}", ctx.getStage());

            Transaction transaction = new Transaction(
                    request.getAccountIdFrom(), request.getAccountIdTo(), request.getAmount(), LocalDateTime.now());

            transactionRepository.save(transaction);
            ctx.setStage(TransferStage.SUCCESS);
        }

        if (ctx.getStage() == TransferStage.SUCCESS) {
            log.info("Transfer process has finished successfully");
        }

        else if (ctx.getStage() == TransferStage.FAILED) {
            log.info("Transfer process terminated with errors");
        }

        else {
            log.error("Inconsistent process state. Check the logic of State Machine. Process={}", process);
        }
    }
}

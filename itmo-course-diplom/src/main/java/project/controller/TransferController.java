package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import project.command.transfer.RefundCommand;
import project.command.transfer.TransferCommand;

/**
 * @author Egor Stepanov
 * @since 13-01-2018.
 */
@RestController
public class TransferController {

    @Autowired
    private TransferCommand transferCommand;

    @Autowired
    private RefundCommand refundCommand;
}

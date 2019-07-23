package com.venkat.moneytransfer.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.venkat.moneytransfer.dto.AccountDTO;
import com.venkat.moneytransfer.dto.MoneyTransfer;
import com.venkat.moneytransfer.service.TransactionService;

import java.util.List;

@Path("/transactions")
public class TransactionController {

    private final TransactionService transactionService = TransactionService.getInstance();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response submitMoneyTransfer(MoneyTransfer trx) {
        List<AccountDTO> result = transactionService.transfer(trx);
        return Response.ok().entity(result).build();
    }

}

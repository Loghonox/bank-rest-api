package com.gig.bankaccountrestapi.controller;


import com.gig.bankaccountrestapi.model.Account;
import com.gig.bankaccountrestapi.model.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public interface TransactionControllerInterface {


    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transaction created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))}),
            @ApiResponse(responseCode = "400", description = "Wrong format",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Field validation failed",
                    content = @Content)})
    @Operation(summary = "Add new Transaction")

    public ResponseEntity<Account> newTransaction(@RequestBody Transaction newTransaction) throws Exception;


}

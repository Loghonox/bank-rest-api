package com.gig.bankaccountrestapi.controller;


import com.gig.bankaccountrestapi.model.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public interface TransactionControllerInterface {


    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transaction created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaction.class))}),
            @ApiResponse(responseCode = "400", description = "Wrong format",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Field validation failed",
                    content = @Content)})
    @Operation(summary = "Add new Transaction")
    ResponseEntity<Transaction> addTransaction(@RequestBody Transaction newTransaction) throws Exception;



    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find an transaction by id",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaction.class)) }),
            @ApiResponse(responseCode = "404", description = "Transaction not found",
                    content = @Content)})
    @Operation(summary = "Find an transaction by id")
    ResponseEntity<Transaction> getAccountById(
            @PathVariable Long transactionId
    ) throws Exception;


    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find all transactions",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaction.class)) }),
            @ApiResponse(responseCode = "404", description = "Transaction not found",
                    content = @Content)})
    @Operation(summary = "Find all transactions")
    ResponseEntity<List<Transaction>> getAll(
    ) throws Exception;

}

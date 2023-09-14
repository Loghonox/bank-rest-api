package com.gig.bankaccountrestapi.controller;

import com.gig.bankaccountrestapi.model.Account;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/account")
public interface AccountControllerInterface {

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create an account",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))}),
            @ApiResponse(responseCode = "400", description = "Wrong format",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Token not found",
                    content = @Content)})
    @Operation(summary = "Create an account")
    public ResponseEntity<Account> createAccount(
            @RequestBody Account newAccount
    ) throws Exception;

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all accounts",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))}),
            @ApiResponse(responseCode = "401", description = "Token not found",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content)})
    @Operation(summary = "Find all account")
    public ResponseEntity<List<Account>> getAll() throws Exception;

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find an account by id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))}),
            @ApiResponse(responseCode = "401", description = "Token not found",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content)})
    @Operation(summary = "Find an account by id")
    public ResponseEntity<Account> getAccountById(
            @PathVariable Long accountId
    ) throws Exception;


    @PatchMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Unathorized",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content)})
    @Operation(summary = "Change account data through id")
    public ResponseEntity<Object> updateAccount(
            @PathVariable Long accountId,
            @RequestBody Account newAccount
    ) throws Exception;


    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Unathorized",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content)})
    @Operation(summary = "Delete account data by id")
    public ResponseEntity<Object> removeAccount(
            @PathVariable Long accountId
    ) throws Exception;
}

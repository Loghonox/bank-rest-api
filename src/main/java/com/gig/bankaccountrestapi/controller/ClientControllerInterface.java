package com.gig.bankaccountrestapi.controller;

import com.gig.bankaccountrestapi.model.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/client")
public interface ClientControllerInterface {

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create an client",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "400", description = "Wrong format",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Token not found",
                    content = @Content)})
    @Operation(summary = "Create an client")
    public ResponseEntity<Client> createClient(
            @RequestBody Client newClient
    ) throws Exception;

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all clients",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "401", description = "Token not found",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Client not found",
                    content = @Content)})
    @Operation(summary = "Find all clients")
    public ResponseEntity<List<Client>> getAll() throws Exception;

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find an client by id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "401", description = "Token not found",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Client not found",
                    content = @Content)})
    @Operation(summary = "Find an client by id")
    public ResponseEntity<Client> getClientById(
            @PathVariable Long clientId
    ) throws Exception;


    @PatchMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Unathorized",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Client not found",
                    content = @Content)})
    @Operation(summary = "Change client data through id")
    public ResponseEntity<Object> updateClient(
            @PathVariable Long clientId,
            @RequestBody Client newClient
    ) throws Exception;


    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Unathorized",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Client not found",
                    content = @Content)})
    @Operation(summary = "Delete client data by id")
    public ResponseEntity<Object> removeClient(
            @PathVariable Long clientId
    ) throws Exception;
}

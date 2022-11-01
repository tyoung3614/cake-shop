package com.tara.cakeshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.tara.cakeshop.entity.Cake;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/cake")
@OpenAPIDefinition(info = @Info(title = "Tara's Cake Shop"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface CakeController {

  // create cake order
//@formatter:off
    @Operation(
        summary = "Creates a cake order",
        description = "Creates a cake order given the cake name, client ID, type ID, and price for the order",
        responses = {
            @ApiResponse(responseCode = "200", 
                         description = "A cake order is returned", 
                         content = @Content(
                             mediaType = "application/Json", 
                             schema = @Schema(implementation = Cake.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid", 
                content = @Content(mediaType = "application/Json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No cake orders were found with the input criteria", 
                content = @Content(mediaType = "application/Json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred", 
                content = @Content(mediaType = "application/Json")),
        },
        parameters = {
            @Parameter(
                name = "cake name", 
                allowEmptyValue = false, 
                required = true, 
                description = "The cake name (i.e., 'Wedding')"),
            @Parameter(
                name = "client Id", 
                allowEmptyValue = false, 
                required = true, 
                description = "The client ID (i.e., '1')"),
            @Parameter(
                name = "cake Id", 
                allowEmptyValue = false, 
                required = true, 
                description = "The type ID (i.e., '1')"),
            @Parameter(
                name = "price", 
                allowEmptyValue = false, 
                required = true, 
                description = "The price of the cake (i.e., '25')"),
         }     // @formatter:on
  )
  @PostMapping("/create")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Cake createCake(@RequestBody CakeRequest cakeRequest);

  // get cake order

  //@formatter:off
    @Operation(
        summary = "Displays a cake order",
        description = "Displays a cake order given the cake ID for the order",
        responses = {
            @ApiResponse(responseCode = "200", 
                         description = "A cake order is returned", 
                         content = @Content(
                             mediaType = "application/Json", 
                             schema = @Schema(implementation = Cake.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid", 
                content = @Content(mediaType = "application/Json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No cake orders were found with the input criteria", 
                content = @Content(mediaType = "application/Json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred", 
                content = @Content(mediaType = "application/Json")),
        },
        parameters = {
            @Parameter(
                name = "cake ID", 
                allowEmptyValue = false, 
                required = true, 
                description = "The cake ID (i.e., '1')"),
         }     // @formatter:on
  )
  @PostMapping("/get")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Cake getCake(@RequestBody long cakeId);



  // update cake order

  //@formatter:off
    @Operation(
        summary = "Updates a cake order",
        description = "Updates a cake order given the cake name, client ID, type ID, and price for the order",
        responses = {
            @ApiResponse(responseCode = "200", 
                         description = "A cake order is returned", 
                         content = @Content(
                             mediaType = "application/Json", 
                             schema = @Schema(implementation = Cake.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid", 
                content = @Content(mediaType = "application/Json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No cake orders were found with the input criteria", 
                content = @Content(mediaType = "application/Json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred", 
                content = @Content(mediaType = "application/Json")),
        },
        parameters = {
            @Parameter(
                name = " cake name", 
                allowEmptyValue = false, 
                required = true, 
                description = "The cake name (i.e., 'Wedding')"),
            @Parameter(
                name = "client Id", 
                allowEmptyValue = false, 
                required = true, 
                description = "The client ID (i.e., '1')"),
            @Parameter(
                name = "type Id", 
                allowEmptyValue = false, 
                required = true, 
                description = "The type ID (i.e., '1')"),
            @Parameter(
                name = "price", 
                allowEmptyValue = false, 
                required = true, 
                description = "The price of the cake (i.e., '25')"),
         }     // @formatter:on
  )
  @PostMapping("/update")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Cake updateCake(@RequestBody CakeRequest cakeRequest);


  // delete cake order

  //@formatter:off
    @Operation(
        summary = "Deletes a cake order",
        description = "Deletes a cake order given the cake ID for the order",
        responses = {
            @ApiResponse(responseCode = "200", 
                         description = "A cake order is returned", 
                         content = @Content(
                             mediaType = "application/Json", 
                             schema = @Schema(implementation = Cake.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid", 
                content = @Content(mediaType = "application/Json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No cake orders were found with the input criteria", 
                content = @Content(mediaType = "application/Json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred", 
                content = @Content(mediaType = "application/Json")),
        },
        parameters = {
            @Parameter(
                name = "cake ID", 
                allowEmptyValue = false, 
                required = false, 
                description = "The cake ID (i.e., '1')"),
         }     // @formatter:on
  )
  @PostMapping("/delete")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Cake deleteCake(@RequestBody long cakeId);

}

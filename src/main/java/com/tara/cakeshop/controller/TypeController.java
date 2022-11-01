package com.tara.cakeshop.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.tara.cakeshop.entity.Type;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/types")
@OpenAPIDefinition(info = @Info(title = "Tara's Cake Shop"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface TypeController {
  
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Type> getTypes();
}
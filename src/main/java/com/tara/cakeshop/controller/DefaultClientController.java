package com.tara.cakeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.tara.cakeshop.dao.ClientDao;
import com.tara.cakeshop.entity.Client;

public class DefaultClientController implements ClientController {
  
  @Autowired
  private ClientDao clientDao;
  
  @Override
  public Client createClient(Client createClientRequest) {
    return clientDao.createClient(createClientRequest);
  }

}

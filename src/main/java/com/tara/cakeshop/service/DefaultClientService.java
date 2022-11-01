package com.tara.cakeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tara.cakeshop.dao.ClientDao;
import com.tara.cakeshop.entity.Client;

@Service
public class DefaultClientService implements ClientService {

  @Autowired
  ClientDao clientDao;
  
  @Override
  public Client CreateClient(Client clientRequest) {

    return clientDao.createClient(clientRequest);
  }

}

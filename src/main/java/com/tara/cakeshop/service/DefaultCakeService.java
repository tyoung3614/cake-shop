package com.tara.cakeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tara.cakeshop.controller.CakeRequest;
import com.tara.cakeshop.dao.CakeDao;
import com.tara.cakeshop.entity.Cake;

@Service
public class DefaultCakeService implements CakeService {

  @Autowired
  private CakeDao cakeDao;

  @Override
  public Cake createCake(CakeRequest cakeRequest) {
    Cake cake = new Cake();
    cake.setName(cakeRequest.getName());
    cake.setClientId(cakeRequest.getClientId());
    cake.setPrice(cakeRequest.getPrice());
    cake.setCakeTypes(cakeRequest.getTypes());
    return cakeDao.saveCake(cake);
  }

  @Override
  public Cake getCake(long cakeId) {
    return cakeDao.getOrder(cakeId);
  }

  @Override
  public Cake updateCake(CakeRequest cakeRequest) {
    Cake cake = new Cake();
    cake.setName(cakeRequest.getName());
    cake.setClientId(cakeRequest.getClientId());
    cake.setPrice(cakeRequest.getPrice());
    return cakeDao.updateCake(cake);
  }

  @Override
  public int deleteCake(long cakeId) {
    return cakeDao.deleteCake(cakeId);
  }

}

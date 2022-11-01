package com.tara.cakeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.tara.cakeshop.entity.Cake;
import com.tara.cakeshop.service.CakeService;

@RestController
public class DefaultCakeController implements CakeController {

  @Autowired
  private CakeService cakeService;

  public Cake createCake(CakeRequest cakeRequest) {
    return cakeService.createCake(cakeRequest);
  }

  public Cake getCake(long cakeId) {

    return cakeService.getCake(cakeId);
  }

  public Cake updateCake(CakeRequest cakeRequest) {

    return cakeService.updateCake(cakeRequest);
  }

  public Cake deleteCake(long cakeId) {

    return cakeService.deleteCake(cakeId);
  }
}

package com.tara.cakeshop.service;

import com.tara.cakeshop.controller.CakeRequest;
import com.tara.cakeshop.entity.Cake;

public interface CakeService {

  public Cake createCake(CakeRequest cakeRequest);

  public Cake getCake(long cakeId);

  public Cake updateCake(CakeRequest cakeRequest);

  public Cake deleteCake(long cakeId);
}

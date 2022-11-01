package com.tara.cakeshop.dao;

import com.tara.cakeshop.entity.Cake;

public interface CakeDao {
  
  public Cake saveCake(Cake cake);

  public Cake updateCake(Cake cake);
  
  public Cake getOrder(long cakeId);

  public Cake deleteCake(long cakeId);

}

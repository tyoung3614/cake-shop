package com.tara.cakeshop.dao;

import java.util.List;
import com.tara.cakeshop.entity.Type;

public interface TypeDao {
  public List<Type> getTypesFromDatabase();
  
}

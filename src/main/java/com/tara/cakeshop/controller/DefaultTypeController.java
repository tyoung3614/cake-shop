/**
 * 
 */
package com.tara.cakeshop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.tara.cakeshop.dao.TypeDao;
import com.tara.cakeshop.entity.Type;


public class DefaultTypeController implements TypeController {
  

  @Autowired
  private TypeDao typeDao;
  
  @Override
  public List<Type> getTypes() {
    return typeDao.getTypes();
  }

}

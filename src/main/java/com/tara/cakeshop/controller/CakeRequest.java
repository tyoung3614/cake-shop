package com.tara.cakeshop.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class CakeRequest {

  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String name;
  
  @Positive
  private long clientId;
  
  private BigDecimal price;
  
  private long cakeId;
  
  private List<String> types;
}

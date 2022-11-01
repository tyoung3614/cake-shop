package com.tara.cakeshop.entity;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cake {
  private long cakeId;
  private String name;
  private BigDecimal price;
  private long clientId;
  private List<String> cakeTypes;
}

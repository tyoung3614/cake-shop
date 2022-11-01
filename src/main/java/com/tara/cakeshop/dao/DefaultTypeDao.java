package com.tara.cakeshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.tara.cakeshop.entity.Cake;
import com.tara.cakeshop.entity.Type;

@Component
public class DefaultTypeDao implements TypeDao {

  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Type> getTypes() {
    String sql = "select * from type";
    
    return jdbcTemplate.query(sql, new RowMapper<Type>() {
      @Override
      public Type mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Type.builder()
            .typeId(rs.getLong("type_id"))
            .typeText(rs.getString("type_text"))
            .build();
        // @formatter:on
      }
    });
  }

}

package com.tara.cakeshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.tara.cakeshop.entity.Cake;

@Component
public class DefaultCakeDao implements CakeDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Cake saveCake(Cake cake) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    String sql =
        "insert into cake (name, client_id, price) values (:cakeName, :clientId, :cakePrice);";
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    namedParameters.addValue("cakeName", cake.getName());
    namedParameters.addValue("clientId", cake.getClientId());
    namedParameters.addValue("cakePrice", cake.getPrice());
    jdbcTemplate.update(sql, namedParameters, keyHolder);
    
    String cakeTypeSql =
        "insert into cake_type (cake_id,type_id) values (:cakeId, :typeId);";
    MapSqlParameterSource cakeTypeNamedParameters = new MapSqlParameterSource();
    cakeTypeNamedParameters.addValue("cakeId", keyHolder.getKey().longValue());
    cakeTypeNamedParameters.addValue("typeId", cake.getClientId());
    jdbcTemplate.update(cakeTypeSql, cakeTypeNamedParameters);
    cake.setCakeId(keyHolder.getKey().longValue());
    return cake;
  }

  public Cake getOrder(long cakeId) {
    String sql = "select * from cake where cake_id = :cakeId;";
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    namedParameters.addValue("cakeId", cakeId);
    return jdbcTemplate.query(sql, namedParameters, new RowMapper<Cake>() {
      @Override
      public Cake mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Cake.builder()
            .name(rs.getString("name"))
            .cakeId(rs.getLong("cake_id"))
            .clientId(rs.getLong("client_id"))
            .price(rs.getBigDecimal("price"))
            .build();
        // @formatter:on
      }
    }).get(0);
  }

  @Override
  public Cake updateCake(Cake cake) {
    String sql =
        "update cake set name = :cakeName, client_id = :clientId, price = price where cake_id = :cakeId;";
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    namedParameters.addValue("cakeId", cake.getCakeId());    
    namedParameters.addValue("cakeName", cake.getName());
    namedParameters.addValue("clientId", cake.getClientId());
    namedParameters.addValue("cakePrice", cake.getPrice());

    jdbcTemplate.update(sql, namedParameters);
    return cake;
  }

  @Override
  public Cake deleteCake(long cakeId) {
    String sql = "delete from cake where cake_id = :cakeId;";
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    namedParameters.addValue("cakeId", cakeId);
    return jdbcTemplate.query(sql, namedParameters, new RowMapper<Cake>() {
      @Override
      public Cake mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Cake.builder()
            .name(rs.getString("name"))
            .cakeId(rs.getLong("cake_id"))
            .clientId(rs.getLong("client_id"))
            .price(rs.getBigDecimal("price"))
            .build();
        // @formatter:on
      }
    }).get(0);
  }
  }

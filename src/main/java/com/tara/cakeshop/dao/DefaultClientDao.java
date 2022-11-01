package com.tara.cakeshop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.tara.cakeshop.entity.Client;

@Component
public class DefaultClientDao implements ClientDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  public Client createClient(Client client) {
    
    String sql = "INSERT INTO client (name, phone, email) VALUES(:name, :phone, :email);";
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    namedParameters.addValue("name", client.getName());
    namedParameters.addValue("phone", client.getPhone());
    namedParameters.addValue("email", client.getEmail());
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(sql, namedParameters, keyHolder);
    client.setClientId(keyHolder.getKey().longValue());
    return client;
  }

}

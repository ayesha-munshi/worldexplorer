package com.data.worldexplorer.repository;

import com.data.worldexplorer.mapper.CityRowMapper;
import com.data.worldexplorer.mapper.GlobalTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<GlobalTreeNode<String>> findAll(){
        List<GlobalTreeNode<String>> worldTree = jdbcTemplate.query("SELECT * FROM CITY", new CityRowMapper());
        return worldTree;
    }
}

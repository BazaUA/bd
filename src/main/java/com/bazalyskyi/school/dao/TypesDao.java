package com.bazalyskyi.school.dao;

import com.bazalyskyi.school.dao.Mappers.SpecializationRowMapper;
import com.bazalyskyi.school.dao.Mappers.TypeRowMapper;
import com.bazalyskyi.school.entity.Specialization;
import com.bazalyskyi.school.entity.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class TypesDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Types> getAllTypes() {
        String sql = "SELECT * FROM types";
        RowMapper<Types> rowMapper = new TypeRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Types getTypeById(int id) {
        String sql = "SELECT * FROM `types` WHERE `Id_types` = ?";
        RowMapper<Types> rowMapper = new TypeRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
    }
}

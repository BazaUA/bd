package com.bazalyskyi.school.dao;

import com.bazalyskyi.school.dao.Mappers.PeculiarityRowMapper;
import com.bazalyskyi.school.dao.Mappers.QualificationRowMapper;
import com.bazalyskyi.school.entity.PeculiaritiesOfPupils;
import com.bazalyskyi.school.entity.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class QualificationDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Qualification> getAllQualifications() {
        String sql = "SELECT * FROM qualifications";
        RowMapper<Qualification> rowMapper = new QualificationRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Qualification getQualificationById(int id){
        String sql = "SELECT * FROM `qualifications` WHERE `id_qualification` = ?";
        RowMapper<Qualification> rowMapper = new QualificationRowMapper();
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

}

package com.bazalyskyi.school.dao;

import com.bazalyskyi.school.dao.Mappers.BranchRowMapper;
import com.bazalyskyi.school.dao.Mappers.ParallelRowMapper;
import com.bazalyskyi.school.entity.BranchKnowledge;
import com.bazalyskyi.school.entity.Parallel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ParallelsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Parallel> getAllParallels() {
        String sql = "SELECT * FROM parallels";
        RowMapper<Parallel> rowMapper = new ParallelRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Parallel getParallelById(int id) {
        String sql = "SELECT * FROM parallels WHERE parallels.Id_parallel = ?";
        RowMapper<Parallel> rowMapper = new ParallelRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
    }
}

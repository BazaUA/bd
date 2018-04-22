package com.bazalyskyi.school.dao;

import com.bazalyskyi.school.dao.Mappers.BranchRowMapper;
import com.bazalyskyi.school.dao.Mappers.ClassRowMapper;
import com.bazalyskyi.school.entity.BranchKnowledge;
import com.bazalyskyi.school.entity.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class BranchKnowDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BranchKnowledge> getAllBranches() {
        String sql = "SELECT * FROM branch_knowledge";
        RowMapper<BranchKnowledge> rowMapper = new BranchRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

}

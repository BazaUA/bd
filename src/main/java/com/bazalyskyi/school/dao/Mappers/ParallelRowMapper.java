package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.BranchKnowledge;
import com.bazalyskyi.school.entity.Parallel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParallelRowMapper implements RowMapper<Parallel> {

    @Override
    public Parallel mapRow(ResultSet resultSet, int i) throws SQLException {
        Parallel s = new Parallel();
        s.setId(resultSet.getInt(1));
        s.setName(resultSet.getString(2));
        return s;
    }
}

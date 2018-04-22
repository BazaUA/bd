package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.BranchKnowledge;
import com.bazalyskyi.school.entity.ClassRoom;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BranchRowMapper implements RowMapper<BranchKnowledge> {

    @Override
    public BranchKnowledge mapRow(ResultSet resultSet, int i) throws SQLException {
        BranchKnowledge s = new BranchKnowledge();
        s.setId(resultSet.getInt(1));
        s.setName(resultSet.getString(2));
        return s;
    }
}

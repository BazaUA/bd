package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.Specialization;
import com.bazalyskyi.school.entity.Types;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeRowMapper implements RowMapper<Types> {

    @Override
    public Types mapRow(ResultSet resultSet, int i) throws SQLException {
        Types s = new Types();
        s.setId(resultSet.getInt(1));
        s.setName(resultSet.getString(2));
        return s;
    }
}

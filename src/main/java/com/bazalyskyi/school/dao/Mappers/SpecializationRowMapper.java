package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.Qualification;
import com.bazalyskyi.school.entity.Specialization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecializationRowMapper implements RowMapper<Specialization> {

    @Override
    public Specialization mapRow(ResultSet resultSet, int i) throws SQLException {
        Specialization s = new Specialization();
        s.setId(resultSet.getInt(1));
        s.setName(resultSet.getString(2));
        return s;
    }
}

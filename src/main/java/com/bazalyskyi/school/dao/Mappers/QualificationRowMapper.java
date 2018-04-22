package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.PeculiaritiesOfPupils;
import com.bazalyskyi.school.entity.Qualification;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QualificationRowMapper implements RowMapper<Qualification> {

    @Override
    public Qualification mapRow(ResultSet resultSet, int i) throws SQLException {
        Qualification s = new Qualification();
        s.setId(resultSet.getInt(1));
        s.setName(resultSet.getString(2));
        return s;
    }
}

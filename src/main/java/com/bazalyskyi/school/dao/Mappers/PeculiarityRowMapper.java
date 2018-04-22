package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.Parallel;
import com.bazalyskyi.school.entity.PeculiaritiesOfPupils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeculiarityRowMapper implements RowMapper<PeculiaritiesOfPupils> {

    @Override
    public PeculiaritiesOfPupils mapRow(ResultSet resultSet, int i) throws SQLException {
        PeculiaritiesOfPupils s = new PeculiaritiesOfPupils();
        s.setId(resultSet.getInt(1));
        s.setPeculiariti(resultSet.getString(2));
        s.setCategory(resultSet.getString(3));
        s.setNumberORseries(resultSet.getString(4));
        return s;
    }
}

package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.Pupils;
import com.bazalyskyi.school.entity.Subjects;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PupilRowMapper implements RowMapper<Pupils> {

    @Override
    public Pupils mapRow(ResultSet resultSet, int i) throws SQLException {
        Pupils s = new Pupils();
        s.setId(resultSet.getInt(1));
        s.setSurname(resultSet.getString(2));
        s.setName(resultSet.getString(3));
        s.setMidlename(resultSet.getString(4));
        s.setSex(resultSet.getString(5));
        s.setMedal(resultSet.getInt(6));
        s.setСlassRoom_id_classes(resultSet.getInt(7));
        return s;
    }
}

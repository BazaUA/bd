package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.Personnel;
import com.bazalyskyi.school.entity.Subjects;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonnelRowMapper implements RowMapper<Personnel> {

    @Override
    public Personnel mapRow(ResultSet resultSet, int i) throws SQLException {
        Personnel s = new Personnel();
        s.setId(resultSet.getInt(1));
        s.setSurname(resultSet.getString(2));
        s.setName(resultSet.getString(3));
        s.setMidlename(resultSet.getString(4));
        s.setWorkPosition(resultSet.getString(5));
        s.setSex(resultSet.getString(6));
        s.setDate_laste_att(resultSet.getString(7));
        s.setTariff_rate(resultSet.getInt(8));
        s.setRank(resultSet.getString(9));
        s.setDate_employment(resultSet.getString(10));
        s.setEducation(resultSet.getString(11));
        s.setQUALIFICATIONS_id_qualification(resultSet.getInt(12));
        return s;
    }
}

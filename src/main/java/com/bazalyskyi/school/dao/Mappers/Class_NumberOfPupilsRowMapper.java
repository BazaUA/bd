package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.dto.Class_NumberOfPupilsDTO;
import com.bazalyskyi.school.entity.BranchKnowledge;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Class_NumberOfPupilsRowMapper implements RowMapper<Class_NumberOfPupilsDTO> {

    @Override
    public Class_NumberOfPupilsDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        Class_NumberOfPupilsDTO s = new Class_NumberOfPupilsDTO();
        s.setIdClass(resultSet.getInt(1));
        s.setClassRoom(resultSet.getString(2));
        s.setCount(resultSet.getInt(3));
        return s;
    }
}

package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.ClassRoom;
import com.bazalyskyi.school.entity.Subjects;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassRowMapper implements RowMapper<ClassRoom> {

    @Override
    public ClassRoom mapRow(ResultSet resultSet, int i) throws SQLException {
        ClassRoom s = new ClassRoom();
        s.setId(resultSet.getInt(1));
        s.setName(resultSet.getString(2));
        s.setChange(resultSet.getInt(3));
        s.setProfile(resultSet.getString(4));
        s.setLimitNumber(resultSet.getInt(5));
        s.setDescription(resultSet.getString(6));
        s.setRoomId(resultSet.getInt(7));
        s.setParalelId(resultSet.getInt(8));
        return s;
    }
}

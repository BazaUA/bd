package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.Room;
import com.bazalyskyi.school.entity.Subjects;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomRowMapper implements RowMapper<Room> {

    @Override
    public Room mapRow(ResultSet resultSet, int i) throws SQLException {
        Room s = new Room();
        s.setId(resultSet.getInt(1));
        s.setName(resultSet.getString(2));
        s.setAvailable(resultSet.getString(3));
        s.setSeats(resultSet.getInt(4));
        s.setArea(resultSet.getDouble(5));
        s.setSpecialization(resultSet.getString(6));
        s.setResponsible(resultSet.getString(7));
        s.setLeased(resultSet.getInt(8));
        s.setTYPES_Id_types(resultSet.getInt(9));
        return s;
    }
}

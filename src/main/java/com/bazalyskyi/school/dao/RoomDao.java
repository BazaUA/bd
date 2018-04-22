package com.bazalyskyi.school.dao;

import com.bazalyskyi.school.dao.Mappers.ClassRowMapper;
import com.bazalyskyi.school.dao.Mappers.RoomRowMapper;
import com.bazalyskyi.school.entity.ClassRoom;
import com.bazalyskyi.school.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class RoomDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addRoom(Room c) {
        String sql = "INSERT INTO `rooms` (`Name`, `Available`, `Seats`, `Area`, `Specialization`, `Responsible`, `leased`, `TYPES_Id_types`) VALUES (?, ?, ?, ?, ?,?,?,?);";
        jdbcTemplate.update(sql, c.getName(),c.getAvailable(),c.getSeats(),c.getArea(),c.getSpecialization(),c.getResponsible(),c.getLeased(),c.getTYPES_Id_types());
    }

    public List<Room> getAllRooms() {
        String sql = "SELECT * FROM rooms";
        RowMapper<Room> rowMapper = new RoomRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Room getRoomById(int id) {
        String sql = "SELECT * FROM rooms WHERE id_room = ?";
        RowMapper<Room> rowMapper = new RoomRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

    public void updateRoom(Room c) {
        String sql = "UPDATE `rooms` SET `Name` = ?, `Available` = ?, `Seats` = ?, `Area` = ?, `Specialization` = ?, `Responsible` = ?, `leased` = ?, `TYPES_Id_types` = ? WHERE `rooms`.`id_room` = ?";
        jdbcTemplate.update(sql, c.getName(),c.getAvailable(),c.getSeats(),c.getArea(),c.getSpecialization(),c.getResponsible(),c.getLeased(),c.getTYPES_Id_types(),c.getId());
    }

    public void deleteRoom(int id) {
        String sql = "DELETE FROM rooms WHERE `сlasses`.`id_room` = ?";
        jdbcTemplate.update(sql,id);
    }
}

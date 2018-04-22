package com.bazalyskyi.school.service;

import com.bazalyskyi.school.dao.Mappers.RoomRowMapper;
import com.bazalyskyi.school.dao.RoomDao;
import com.bazalyskyi.school.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomService {
    @Autowired
    RoomDao dao;

    public void addRoom(Room c) {
       dao.addRoom(c);
    }

    public List<Room> getAllRooms() {
        return dao.getAllRooms();
    }

    public Room getRoomById(int id) {
        return dao.getRoomById(id);
    }

    public void updateRoom(Room c) {
       dao.updateRoom(c);
    }

    public void deleteRoom(int id) {
        dao.deleteRoom(id);
    }
    
}

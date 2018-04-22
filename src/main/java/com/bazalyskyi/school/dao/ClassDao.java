package com.bazalyskyi.school.dao;

import com.bazalyskyi.school.dao.Mappers.ClassRowMapper;
import com.bazalyskyi.school.dao.Mappers.Class_NumberOfPupilsRowMapper;
import com.bazalyskyi.school.dao.Mappers.SubjectRowMapper;
import com.bazalyskyi.school.dto.Class_NumberOfPupilsDTO;
import com.bazalyskyi.school.entity.ClassRoom;
import com.bazalyskyi.school.entity.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ClassDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addClass(ClassRoom c) {
        String sql = "INSERT INTO `classes` (`Name_classe`, `change`, `profile`, `Limit_number`, `Description`, `ROOMS_id_room`, `PARALLELS_Id_parallel`) VALUES (?, ?, ?, ?, ?,?,?);";
        jdbcTemplate.update(sql, c.getName(),c.getChange(),c.getProfile(),c.getLimitNumber(),c.getDescription(),c.getRoomId(),c.getParalelId());
    }

    public List<ClassRoom> getAllClasses() {
        String sql = "SELECT * FROM `classes`";
        RowMapper<ClassRoom> rowMapper = new ClassRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public ClassRoom getClassRoomById(int id) {
        String sql = "SELECT * FROM `classes` WHERE `id_classes` = ?";
        RowMapper<ClassRoom> rowMapper = new ClassRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

    public void updateClassRoom(ClassRoom c) {
        String sql = "UPDATE `classes` SET `Name_classe` = ?, `change` = ?, `profile` = ?, `Limit_number` = ?, `Description` = ?, `ROOMS_id_room` = ?, `PARALLELS_Id_parallel` = ? WHERE `classes`.`id_classes` = ?";
        jdbcTemplate.update(sql,c.getName(),c.getChange(),c.getProfile(),c.getLimitNumber(),c.getDescription(),c.getRoomId(),c.getParalelId(),c.getId());
    }

    public void deleteClassRoom(int id) {
        String sql = "DELETE FROM `classes` WHERE `classes`.`id_classes` = ?";
        jdbcTemplate.update(sql,id);
    }

    public ClassRoom getClassRoomByPupilId(int id) {
        String sql = "SELECT `id_classes`,`Name_classe`,`change`,`profile`,`Limit_number`,`Description`,`ROOMS_id_room`,`PARALLELS_Id_parallel` FROM `classes` AS `c` INNER JOIN `pupils` AS `p` ON `p`.`classes_id_classes` = `c`.`id_classes` WHERE `p`.`Id_ pupil` = ?";
        RowMapper<ClassRoom> rowMapper = new ClassRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

    public List<Class_NumberOfPupilsDTO> getClass_NumberOfPupils() {
        String sql = "SELECT `id_classes`, `Name_classe`, COUNT(`Id_ pupil`) FROM `classes` as `c` LEFT JOIN `pupils` as `p` on `c`.`id_classes` = `p`.`classes_id_classes` GROUP BY `Name_classe`";
        RowMapper<Class_NumberOfPupilsDTO> rowMapper = new Class_NumberOfPupilsRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }
}

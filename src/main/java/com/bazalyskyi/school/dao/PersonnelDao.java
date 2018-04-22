package com.bazalyskyi.school.dao;

import com.bazalyskyi.school.dao.Mappers.PersonnelRowMapper;
import com.bazalyskyi.school.dao.Mappers.RoomRowMapper;
import com.bazalyskyi.school.entity.Personnel;
import com.bazalyskyi.school.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class PersonnelDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addPersonnel(Personnel c) {
        String sql = "INSERT INTO `personnel` (`Surname`, `Name`, `Middle_name`, `Work_position`, `sex`, `Date_laste_att`, `tariff _rate`, `rank`, `Date_employment`, `education`, `QUALIFICATIONS_id_qualification`) VALUES (?, ?, ?, ?, ?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, c.getSurname(),c.getName(),c.getMidlename(),c.getWorkPosition(),c.getSex(),c.getDate_laste_att(),c.getTariff_rate(),c.getRank(),c.getDate_employment(),c.getEducation(),c.getQUALIFICATIONS_id_qualification());
    }

    public List<Personnel> getAllPersonnel() {
        String sql = "SELECT * FROM `personnel`";
        RowMapper<Personnel> rowMapper = new PersonnelRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Personnel getPersonnelById(int id) {
        String sql = "SELECT * FROM personnel WHERE id_employee = ?";
        RowMapper<Personnel> rowMapper = new PersonnelRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

    public void updatePersonnel(Personnel c) {
        String sql = "UPDATE `personnel` SET `Surname` = ?, `Name` = ?, `Middle_name` = ?, `Work_position` = ?, `sex` = ?, `Date_laste_att` = ?, `tariff _rate` = ?, `rank` = ?, `Date_employment` = ?, `education` = ?, `QUALIFICATIONS_id_qualification` = ? WHERE `personnel`.`id_employee` = ?";
        jdbcTemplate.update(sql, c.getSurname(),c.getName(),c.getMidlename(),c.getWorkPosition(),c.getSex(),c.getDate_laste_att(),c.getTariff_rate(),c.getRank(),c.getDate_employment(),c.getEducation(),c.getQUALIFICATIONS_id_qualification(),c.getId());
    }

    public void deletePersonnel(int id) {
        String sql = "DELETE FROM personnel WHERE `personnel`.`id_employee` = ?";
        jdbcTemplate.update(sql,id);
    }
}

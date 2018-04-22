package com.bazalyskyi.school.dao;

import com.bazalyskyi.school.dao.Mappers.PersonnelRowMapper;
import com.bazalyskyi.school.dao.Mappers.PupilRowMapper;
import com.bazalyskyi.school.entity.Personnel;
import com.bazalyskyi.school.entity.Pupils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class PupilDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addPupil(Pupils c) {
        String sql = "INSERT INTO `pupils` (`Surname`, `Name`, `Middle_name`, `Sex`, `Medal`, `classes_id_classes`) VALUES (?, ?, ?, ?, ?,?)";
        jdbcTemplate.update(sql, c.getSurname(),c.getName(),c.getMidlename(),c.getSex(),c.getMedal(),c.getСlassRoom_id_classes());
        sql = "SELECT MAX(`Id_ pupil`) FROM `pupils` ";
        int id = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(id);
        sql = "INSERT INTO `users` (`username`, `password`, `enabled`, `fk_id`) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,c.getName()+id,passwordEncoder.encode(c.getName()+id),1,id);
        sql = "INSERT INTO `user_roles` (`username`, `role`) VALUES ( ?, 'ROLE_PUPIL') ";
        jdbcTemplate.update(sql,c.getName()+id);
    }

    public List<Pupils> getAllPupils() {
        String sql = "SELECT * FROM pupils";
        RowMapper<Pupils> rowMapper = new PupilRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Pupils getPupilById(int id) {
        String sql = "SELECT * FROM `pupils` WHERE `Id_ pupil` = ?";
        RowMapper<Pupils> rowMapper = new PupilRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

    public void updatePupil(Pupils c) {
        String sql = "UPDATE `pupils` SET `Surname` = ?, `Name` = ?, `Middle_name` = ?, `Sex` = ?, `Medal` = ?, `classes_id_classes` = ? WHERE `pupils`.`Id_ pupil` = ?";
        jdbcTemplate.update(sql, c.getSurname(),c.getName(),c.getMidlename(),c.getSex(),c.getMedal(),c.getСlassRoom_id_classes(),c.getId());
    }

    public void deletePupil(int id) {
        String sql = "DELETE FROM pupils WHERE `pupils`.`Id_ pupil` = ?";
        jdbcTemplate.update(sql,id);
    }
}

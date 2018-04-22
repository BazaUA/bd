package com.bazalyskyi.school.dao;

import com.bazalyskyi.school.entity.Subjects;
import com.bazalyskyi.school.entity.UserEntity;
import com.bazalyskyi.school.entity.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Transactional
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(UserEntity us, UserRoleEntity ure) {
        String sql = "INSERT INTO `users` (`username`, `password`, `enabled`, `fk_id`) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, us.getUsername(),us.getPassword(),us.getEnebled(),us.getFk_id());
        sql="INSERT INTO `user_roles` (`username`, `role`) VALUES (?, ?);";
        jdbcTemplate.update(sql, ure.getUsername(),ure.getRole());
    }

    public UserEntity getUserById(String id) {
        String sql = "SELECT * FROM `users` WHERE `username` = ?";
            return jdbcTemplate.queryForObject(sql, new ParameterizedRowMapper<UserEntity>() {
            public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(rs.getString(1));
                userEntity.setPassword(rs.getString(2));
                userEntity.setEnebled(rs.getInt(3));
                userEntity.setFk_id(rs.getInt(4));
                return userEntity;
            }
        }, id);


    }

}

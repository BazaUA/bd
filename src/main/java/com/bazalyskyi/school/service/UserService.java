package com.bazalyskyi.school.service;

import com.bazalyskyi.school.dao.UserDao;
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
public class UserService {
    @Autowired
    private UserDao dao;

    public void addUser(UserEntity us, UserRoleEntity ure) {
        dao.addUser(us,ure);
    }

    public UserEntity getUserById(String id) {
        return dao.getUserById(id);
    }

}

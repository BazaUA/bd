package com.bazalyskyi.school.service;

import com.bazalyskyi.school.dao.Mappers.PersonnelRowMapper;
import com.bazalyskyi.school.dao.PersonnelDao;
import com.bazalyskyi.school.entity.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonnelService {
    @Autowired
    PersonnelDao dao;

    public void addPersonnel(Personnel c) {
       dao.addPersonnel(c);
    }

    public List<Personnel> getAllPersonnel() {
      return   dao.getAllPersonnel();
    }

    public Personnel getPersonnelById(int id) {
      return   dao.getPersonnelById(id);
    }

    public void updatePersonnel(Personnel c) {
        dao.updatePersonnel(c);
    }

    public void deletePersonnel(int id) {
        dao.deletePersonnel(id);
    }

}

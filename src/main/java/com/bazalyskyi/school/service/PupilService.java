package com.bazalyskyi.school.service;

import com.bazalyskyi.school.dao.Mappers.PupilRowMapper;
import com.bazalyskyi.school.dao.PupilDao;
import com.bazalyskyi.school.entity.Pupils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PupilService {
    @Autowired
    PupilDao dao;

    public void addPupil(Pupils c) {
        dao.addPupil(c);
    }

    public List<Pupils> getAllPupils() {
       return dao.getAllPupils();
    }

    public Pupils getPupilById(int id) {
        return dao.getPupilById(id);
    }

    public void updatePupil(Pupils c) {
       dao.updatePupil(c);
    }

    public void deletePupil(int id) {
       dao.deletePupil(id);
    }
    
}

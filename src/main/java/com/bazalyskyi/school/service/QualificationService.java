package com.bazalyskyi.school.service;

import com.bazalyskyi.school.dao.QualificationDao;
import com.bazalyskyi.school.entity.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QualificationService {
    @Autowired
    QualificationDao dao;

    public List<Qualification> getAllQualifications() {
        return dao.getAllQualifications();
    }
    public Qualification getQualificationById(int id){
        return dao.getQualificationById(id);
    }
    
}

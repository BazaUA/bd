package com.bazalyskyi.school.service;

import com.bazalyskyi.school.dao.Mappers.SubjectRowMapper;
import com.bazalyskyi.school.dao.SubjectDao;
import com.bazalyskyi.school.entity.BranchKnowledge;
import com.bazalyskyi.school.entity.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectService {
    @Autowired
    SubjectDao dao;

    public void addSubject(Subjects subject) {
       dao.addSubject(subject);
    }

    public List<Subjects> getAllSubjects() {
        return dao.getAllSubjects();
    }

    public Subjects getSubjectById(int id) {
        return dao.getSubjectById(id);
    }

    public void updateSubject(Subjects s) {
       dao.updateSubject(s);
    }

    public void deleteSubject(int id) {
       dao.deleteSubject(id);
    }

    public BranchKnowledge getNameOfBrunchOfKnow(int id) {
        return dao.getNameOfBrunchOfKnow(id);
    }

    public List<Subjects> getAllSubjectByPupilId(int id){
        return dao.getAllSubjectByPupilId(id);
    }
    public List<Subjects> getAllSubjectByPersonnelId(int id){
        return dao.getAllSubjectByPersonnelId(id);
    }
}

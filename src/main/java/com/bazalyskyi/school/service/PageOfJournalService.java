package com.bazalyskyi.school.service;

import com.bazalyskyi.school.dao.ClassDao;
import com.bazalyskyi.school.dao.Mappers.PageOfJournalRowMapper;
import com.bazalyskyi.school.dao.PageOfJournalDao;
import com.bazalyskyi.school.dao.SubjectDao;
import com.bazalyskyi.school.entity.PagesOfJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageOfJournalService {
    @Autowired
    PageOfJournalDao dao;
    @Autowired
    ClassDao classDao;
    @Autowired
    SubjectDao subjectDao;

    public void addPageOfJournal(PagesOfJournal c) {
        dao.addPageOfJournal(c);
    }

    public List<PagesOfJournal> getAllPageOfJournals() {
        return dao.getAllPageOfJournals();
    }


    public PagesOfJournal getPageOfJournalById(int id,int subjects_id_subject,int pERSONNEL_id_employee,int classes_id_classes) {
       return dao.getPageOfJournalById(id, subjects_id_subject, pERSONNEL_id_employee, classes_id_classes);
    }

    public void updatePageOfJournal(PagesOfJournal c) {
        dao.updatePageOfJournal(c);
    }

    public void deletePageOfJournal(int id,int subjects_id_subject,int pERSONNEL_id_employee,int classes_id_classes) {
        dao.deletePageOfJournal(id, subjects_id_subject, pERSONNEL_id_employee, classes_id_classes);
    }

    public List<PagesOfJournal> getAllPagesByPersonnelId(int id) {
        List<PagesOfJournal> pagesOfJournals= dao.getAllPagesByPersonnelId(id);
        for (PagesOfJournal pages:pagesOfJournals){
            pages.setSubject(subjectDao.getSubjectById(pages.getSubjectsIdSubject()).getName());
            pages.setClassRoom(classDao.getClassRoomById(pages.getClassesIdClasses()).getName());
        }
        return pagesOfJournals;
    }
}

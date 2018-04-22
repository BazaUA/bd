package com.bazalyskyi.school.dao;

import com.bazalyskyi.school.dao.Mappers.PageOfJournalRowMapper;
import com.bazalyskyi.school.dao.Mappers.RoomRowMapper;
import com.bazalyskyi.school.entity.PagesOfJournal;
import com.bazalyskyi.school.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class PageOfJournalDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addPageOfJournal(PagesOfJournal c) {
        String sql = "INSERT INTO `pages_of_journal` (`number_pages_journal`, `Page_type`, `Subgroup_num`, `Description`, `Subjects_id_subject`, `PERSONNEL_id_employee`, `classes_id_classes`) VALUES (?, ?, ?, ?, ?,?,?);";
        jdbcTemplate.update(sql, c.getNumberPagesJournal(),c.getPageType(),c.getSubgroup_num(),c.getDescription(),c.getSubjectsIdSubject(),c.getPersonnelIdEmployee(),c.getClassesIdClasses());
    }

    public List<PagesOfJournal> getAllPageOfJournals() {
        String sql = "SELECT * FROM pages_of_journal";
        RowMapper<PagesOfJournal> rowMapper = new PageOfJournalRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }


    public PagesOfJournal getPageOfJournalById(int id,int subjects_id_subject,int pERSONNEL_id_employee,int classes_id_classes) {
        String sql = "SELECT * FROM `pages_of_journal` WHERE `number_pages_journal` = ? AND `Subjects_id_subject` = ? AND `PERSONNEL_id_employee` = ? AND `classes_id_classes` = ?";
        RowMapper<PagesOfJournal> rowMapper = new PageOfJournalRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper,id,subjects_id_subject,pERSONNEL_id_employee,classes_id_classes);
    }

    public void updatePageOfJournal(PagesOfJournal c) {
        String sql = "UPDATE `pages_of_journal` SET `Description` = ? WHERE `pages_of_journal`.`number_pages_journal` = ? AND `pages_of_journal`.`Subjects_id_subject` = ? AND `pages_of_journal`.`PERSONNEL_id_employee` = ? AND `pages_of_journal`.`classes_id_classes` = ?";
        jdbcTemplate.update(sql, c.getDescription(),c.getNumberPagesJournal(),c.getSubjectsIdSubject(),c.getPersonnelIdEmployee(),c.getClassesIdClasses());
    }

    public void deletePageOfJournal(int id,int subjects_id_subject,int pERSONNEL_id_employee,int classes_id_classes) {
        String sql = "DELETE FROM `pages_of_journal` WHERE `number_pages_journal` = ? AND `Subjects_id_subject` = ? AND `PERSONNEL_id_employee` = ? AND `classes_id_classes` = ?";
        jdbcTemplate.update(sql,id,subjects_id_subject,pERSONNEL_id_employee,classes_id_classes);
    }

    public List<PagesOfJournal> getAllPagesByPersonnelId(int id) {
        String sql = "SELECT * FROM `pages_of_journal` WHERE `PERSONNEL_id_employee` = ?";
        RowMapper<PagesOfJournal> rowMapper = new PageOfJournalRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper,id);
    }
}

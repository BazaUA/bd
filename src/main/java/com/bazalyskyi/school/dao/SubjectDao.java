package com.bazalyskyi.school.dao;

import com.bazalyskyi.school.dao.Mappers.BranchRowMapper;
import com.bazalyskyi.school.dao.Mappers.SubjectRowMapper;
import com.bazalyskyi.school.entity.BranchKnowledge;
import com.bazalyskyi.school.entity.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class SubjectDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addSubject(Subjects subject) {
        String sql = "INSERT INTO `subjects` (`Name_subject`, `Name_subject(cutty)`, `subgroup`, `required`, `BRANCH_KNOWLEDGE_Id_Branch_knowledge`) VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, subject.getName(),subject.getName_subjectCutty(),subject.getSubgroup(),subject.getRequired(),subject.getBRANCH_KNOWLEDGE_Id_Branch_knowledge());
    }

    public List<Subjects> getAllSubjects() {
        String sql = "SELECT * FROM subjects";
        RowMapper<Subjects> rowMapper = new SubjectRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Subjects getSubjectById(int id) {
        String sql = "SELECT * FROM subjects WHERE id_subject = ?";
        RowMapper<Subjects> rowMapper = new SubjectRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

    public void updateSubject(Subjects s) {
        String sql = "UPDATE `subjects` SET `Name_subject` = ?, `Name_subject(cutty)` = ?, `subgroup` = ?, `required` = ?, `BRANCH_KNOWLEDGE_Id_Branch_knowledge` = ? WHERE `subjects`.`id_subject` = ?";
        jdbcTemplate.update(sql,s.getName(),s.getName_subjectCutty(),s.getSubgroup(),s.getRequired(),s.getBRANCH_KNOWLEDGE_Id_Branch_knowledge(),s.getId());
    }

    public void deleteSubject(int id) {
        String sql = "DELETE FROM subjects WHERE id_subject = ?";
        jdbcTemplate.update(sql,id);
    }

    public BranchKnowledge getNameOfBrunchOfKnow(int id) {
        String sql = "SELECT * FROM `branch_knowledge` as `b` WHERE `b`.`Id_Branch_knowledge` = ?";
        RowMapper<BranchKnowledge> rowMapper = new BranchRowMapper();
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    public List<Subjects> getAllSubjectByPupilId(int id){
        String sql = "SELECT * FROM `subjects` as `s` INNER JOIN `pages_of_journal` as `p` on `p`.`Subjects_id_subject` = `s`.`id_subject` INNER JOIN `classes` as `c` on `c`.`id_classes` = `p`.`classes_id_classes` INNER JOIN `pupils` as `pup` on `pup`.`classes_id_classes` = `p`.`classes_id_classes` WHERE `pup`.`Id_ pupil` = ?";
        RowMapper<Subjects> rowMapper = new SubjectRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper,id);
    }

    public List<Subjects> getAllSubjectByPersonnelId(int id){
        String sql = "SELECT `id_subject`,`Name_subject`,`Name_subject(cutty)`,`subgroup`,`required`,`BRANCH_KNOWLEDGE_Id_Branch_knowledge` FROM `subjects` as `s` INNER JOIN `pages_of_journal` as `p` on `p`.`Subjects_id_subject` = `s`.`id_subject` INNER JOIN `personnel` as `pers` on `pers`.`id_employee` = `p`.`PERSONNEL_id_employee` WHERE `pers`.`id_employee` = ?";
        RowMapper<Subjects> rowMapper = new SubjectRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper,id);
    }



}

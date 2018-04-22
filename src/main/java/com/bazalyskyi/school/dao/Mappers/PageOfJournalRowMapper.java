package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.PagesOfJournal;
import com.bazalyskyi.school.entity.Subjects;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PageOfJournalRowMapper implements RowMapper<PagesOfJournal> {

    @Override
    public PagesOfJournal mapRow(ResultSet resultSet, int i) throws SQLException {
        PagesOfJournal s = new PagesOfJournal();
        s.setNumberPagesJournal(resultSet.getInt(1));
        s.setPageType(resultSet.getString(2));
        s.setSubgroup_num(resultSet.getInt(3));
        s.setDescription(resultSet.getString(4));
        s.setSubjectsIdSubject(resultSet.getInt(5));
        s.setPersonnelIdEmployee(resultSet.getInt(6));
        s.setClassesIdClasses(resultSet.getInt(7));
        return s;
    }
}

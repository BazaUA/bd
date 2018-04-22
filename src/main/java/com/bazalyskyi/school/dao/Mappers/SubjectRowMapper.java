package com.bazalyskyi.school.dao.Mappers;

import com.bazalyskyi.school.entity.Subjects;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectRowMapper implements RowMapper<Subjects> {

    @Override
    public Subjects mapRow(ResultSet resultSet, int i) throws SQLException {
        Subjects s = new Subjects();
        s.setId(resultSet.getInt(1));
        s.setName(resultSet.getString(2));
        s.setName_subjectCutty(resultSet.getString(3));
        s.setSubgroup(resultSet.getInt(4));
        s.setRequired(resultSet.getInt(5));
        s.setBRANCH_KNOWLEDGE_Id_Branch_knowledge(resultSet.getInt(6));
        return s;
    }
}

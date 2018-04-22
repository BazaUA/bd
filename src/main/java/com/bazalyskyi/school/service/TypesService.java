package com.bazalyskyi.school.service;

import com.bazalyskyi.school.dao.TypesDao;
import com.bazalyskyi.school.entity.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypesService {
    @Autowired
    TypesDao dao;

    public List<Types> getAllTypes() {
        return dao.getAllTypes();
    }

    public Types getTypeById(int id){
        return dao.getTypeById(id);
    }
}

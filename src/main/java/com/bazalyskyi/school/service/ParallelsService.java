package com.bazalyskyi.school.service;

import com.bazalyskyi.school.dao.ParallelsDao;
import com.bazalyskyi.school.entity.Parallel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParallelsService {
    @Autowired
    ParallelsDao dao;

    public List<Parallel> getAllParallels() {
        return dao.getAllParallels();
    }

    public Parallel getParallelById(int id) {
        return dao.getParallelById(id);
    }
    
}

package com.bazalyskyi.school.service;

import com.bazalyskyi.school.dao.BranchKnowDao;
import com.bazalyskyi.school.entity.BranchKnowledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchKnowService {
    @Autowired
    BranchKnowDao dao;

    public List<BranchKnowledge> getAllBranches() {
        return dao.getAllBranches();
    }
}

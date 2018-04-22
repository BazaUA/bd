package com.bazalyskyi.school.service;

import com.bazalyskyi.school.dao.ClassDao;
import com.bazalyskyi.school.dao.Mappers.ClassRowMapper;
import com.bazalyskyi.school.dto.Class_NumberOfPupilsDTO;
import com.bazalyskyi.school.entity.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassService {
    @Autowired
    ClassDao dao;

    public void addClass(ClassRoom c) {
        dao.addClass(c);
    }

    public List<ClassRoom> getAllClasses() {
        return dao.getAllClasses();
    }

    public ClassRoom getClassRoomById(int id) {
        return dao.getClassRoomById(id);
    }

    public void updateClassRoom(ClassRoom c) {
        dao.updateClassRoom(c);
    }

    public void deleteClassRoom(int id) {
       dao.deleteClassRoom(id);
    }

    public ClassRoom getClassRoomByPupilId(int id) {return dao.getClassRoomByPupilId(id);}

    public Map<Integer,Class_NumberOfPupilsDTO> getNumberOfPupils(){
        List<Class_NumberOfPupilsDTO> class_numberOfPupilsDTOS=dao.getClass_NumberOfPupils();
        Map<Integer,Class_NumberOfPupilsDTO> class_numberOfPupilsDTOMap= new HashMap<>();
        for(Class_NumberOfPupilsDTO class_numberOfPupilsDTO:class_numberOfPupilsDTOS){
            class_numberOfPupilsDTOMap.put(class_numberOfPupilsDTO.getIdClass(),class_numberOfPupilsDTO);
        }
        return class_numberOfPupilsDTOMap;
    }
    
}

package com.bazalyskyi.school.controller;

import com.bazalyskyi.school.entity.ClassRoom;
import com.bazalyskyi.school.entity.Pupils;
import com.bazalyskyi.school.entity.Subjects;
import com.bazalyskyi.school.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/pupil")
public class PupilController {
    @Autowired
    SubjectService subjectService;
    @Autowired
    PupilService pupilService;
    @Autowired
    ClassService classService;
    @Autowired
    UserService userService;
    @Autowired
    RoomService roomService;
    @Autowired
    ParallelsService parallelsService;


    @GetMapping("/subjects/my")
    public ModelAndView getMySubjects() {
        ModelAndView modelAndView=new ModelAndView("subjects");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int id=userService.getUserById(currentPrincipalName).getFk_id();
        List<Subjects> dtoList = subjectService.getAllSubjectByPupilId(id);

        for(Subjects s : dtoList){
            int idBrunch=s.getBRANCH_KNOWLEDGE_Id_Branch_knowledge();
            String nameBrunch=subjectService.getNameOfBrunchOfKnow(idBrunch).getName();
            s.setNameOfBranch(nameBrunch);
            if(s.getRequired()==1){
                s.setValue(true);
            }else{
                s.setValue(false);
            }
        }
        modelAndView.addObject("sub","Мої придмети");
        modelAndView.addObject("list",dtoList);
        return modelAndView;
    }

    @GetMapping("/subjects/all")

    public ModelAndView getAllSubjects() {
        ModelAndView modelAndView=new ModelAndView("subjects");
        List<Subjects> dtoList = subjectService.getAllSubjects();
        for(Subjects s : dtoList){
            int idBrunch=s.getBRANCH_KNOWLEDGE_Id_Branch_knowledge();
            String nameBrunch=subjectService.getNameOfBrunchOfKnow(idBrunch).getName();
            s.setNameOfBranch(nameBrunch);
            if(s.getRequired()==1){
                s.setValue(true);
            }else{
                s.setValue(false);
            }
        }
        modelAndView.addObject("sub","Усі придмети");
        modelAndView.addObject("list",dtoList);
        return modelAndView;
    }

    @GetMapping("/class")
    public ModelAndView getClassInfo() {
        ModelAndView modelAndView=new ModelAndView("class_info");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int id=userService.getUserById(currentPrincipalName).getFk_id();
        ClassRoom classRoom = classService.getClassRoomByPupilId(id);
        modelAndView.addObject("c",classRoom);
        modelAndView.addObject("room",roomService.getRoomById(classRoom.getRoomId()).getName());
        modelAndView.addObject("parallel",parallelsService.getParallelById(classRoom.getParalelId()).getName());
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView myInfo() {
        ModelAndView modelAndView=new ModelAndView("my_info");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int id=userService.getUserById(currentPrincipalName).getFk_id();
        Pupils pupil = pupilService.getPupilById(id);
        ClassRoom classRoom = classService.getClassRoomByPupilId(id);
        modelAndView.addObject("p",pupil);
        modelAndView.addObject("class",classRoom.getName());
        return modelAndView;
    }
}

package com.bazalyskyi.school.controller;

import com.bazalyskyi.school.dto.Class_NumberOfPupilsDTO;
import com.bazalyskyi.school.entity.*;
import com.bazalyskyi.school.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {
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
    @Autowired
    PersonnelService personnelService;
    @Autowired
    QualificationService qualificationService;
    @Autowired
    TypesService typesService;
    @Autowired
    PageOfJournalService pageOfJournalService;



    @GetMapping("/subjects/my")
    public ModelAndView getMySubjects() {
        ModelAndView modelAndView=new ModelAndView("subjects_personnel");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int id=userService.getUserById(currentPrincipalName).getFk_id();
        List<Subjects> dtoList = subjectService.getAllSubjectByPersonnelId(id);
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


    @GetMapping("/classes/all")
    public ModelAndView getClassInfo() {
        ModelAndView modelAndView=new ModelAndView("class_info_personnel");
        List<ClassRoom> classRooms = classService.getAllClasses();
        Map<Integer,Class_NumberOfPupilsDTO> class_numberOfPupilsDTOS=classService.getNumberOfPupils();
        for(ClassRoom classRoom:classRooms){
            classRoom.setParalel(parallelsService.getParallelById(classRoom.getParalelId()).getName());
            classRoom.setRoom(roomService.getRoomById(classRoom.getRoomId()).getName());
            classRoom.setCount(class_numberOfPupilsDTOS.get(classRoom.getId()).getCount());
        }

        modelAndView.addObject("list",classRooms);
        return modelAndView;
    }

    @GetMapping("/rooms")
    public ModelAndView getRoomsInfo() {
        ModelAndView modelAndView=new ModelAndView("rooms_info_personnel");
        List<Room> rooms = roomService.getAllRooms();

        for(Room room:rooms){
            if(room.getLeased()==1){
                room.setLeased(true);
            }else {
                room.setLeased(false);
            }
            room.setType(typesService.getTypeById(room.getTYPES_Id_types()).getName());
        }

        modelAndView.addObject("list",rooms);
        return modelAndView;
    }

    @GetMapping("/pupils")
    public ModelAndView getPupilsInfo() {
        ModelAndView modelAndView=new ModelAndView("pupils_personnel");
        List<Pupils> pupils = pupilService.getAllPupils();
        modelAndView.addObject("list",pupils);
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView myInfo() {
        ModelAndView modelAndView=new ModelAndView("personnel_info");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int id=userService.getUserById(currentPrincipalName).getFk_id();
        Personnel personnel = personnelService.getPersonnelById(id);
        Qualification qualification = qualificationService.getQualificationById(personnel.getQUALIFICATIONS_id_qualification());
        personnel.setQualification(qualification.getName());
        modelAndView.addObject("p",personnel);
        return modelAndView;
    }

    @GetMapping("/pages")
    public ModelAndView myPages() {
        ModelAndView modelAndView=new ModelAndView("pages_personnel");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int id=userService.getUserById(currentPrincipalName).getFk_id();
        Personnel personnel = personnelService.getPersonnelById(id);
        List<PagesOfJournal> pagesOfJournals = pageOfJournalService.getAllPagesByPersonnelId(id);
        modelAndView.addObject("list",pagesOfJournals);
        return modelAndView;
    }

    @GetMapping("/pages/add")
    public ModelAndView addPages() {
        ModelAndView modelAndView=new ModelAndView("add_page");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int id=userService.getUserById(currentPrincipalName).getFk_id();
        Personnel personnel = personnelService.getPersonnelById(id);
        List<Personnel> personnels = personnelService.getAllPersonnel();
        List<ClassRoom> classRooms = classService.getAllClasses();
        List<Subjects> subjects = subjectService.getAllSubjects();
        modelAndView.addObject("personnel",personnels);
        modelAndView.addObject("subject",subjects);
        modelAndView.addObject("classes",classRooms);
        return modelAndView;
    }


    @RequestMapping(value = "/pages/{id}/{id2}/{id3}/{id4}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePagesDescription(@PathVariable("id") Integer id,@PathVariable("id2") Integer id2,@PathVariable("id3") Integer id3,@PathVariable("id4") Integer id4) {
        pageOfJournalService.deletePageOfJournal(id,id2,id3,id4);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/pages/add",method = RequestMethod.POST)
    public RedirectView updatePageOfJournal(@RequestParam Integer pageNumber,@RequestParam String pageType,@RequestParam Integer groupNumber,@RequestParam String description,@RequestParam String subjectsIdSubject,@RequestParam String personnelIdEmployee,@RequestParam String classesIdClasses){
        PagesOfJournal page = new PagesOfJournal();
        page.setNumberPagesJournal(pageNumber);
        page.setPageType(pageType);
        page.setSubgroup_num(groupNumber);
        page.setDescription(description);
        page.setSubjectsIdSubject(Integer.parseInt(subjectsIdSubject.substring(0,1)));
        page.setPersonnelIdEmployee(Integer.parseInt(personnelIdEmployee.substring(0,1)));
        page.setClassesIdClasses(Integer.parseInt(classesIdClasses.substring(0,1)));
        pageOfJournalService.addPageOfJournal(page);
        return new RedirectView("/personnel/pages/add");

    }


}

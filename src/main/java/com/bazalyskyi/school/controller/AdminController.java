package com.bazalyskyi.school.controller;

import com.bazalyskyi.school.dao.SubjectDao;
import com.bazalyskyi.school.dto.Class_NumberOfPupilsDTO;
import com.bazalyskyi.school.entity.*;
import com.bazalyskyi.school.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
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
    @Autowired
    BranchKnowService branchKnowService;

    @RequestMapping(value = "/zvit", method = RequestMethod.GET)
    public ModelAndView getExcel(){
        List<Pupils> pupils = pupilService.getAllPupils();
        return new ModelAndView(new ExcelReportView(), "pupils", pupils);
    }


    @GetMapping("/subjects")
    public ModelAndView getAllSubjects() {
        ModelAndView modelAndView=new ModelAndView("subject_admin");
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

    @GetMapping("/classes")
    public ModelAndView getClassInfo() {
        ModelAndView modelAndView=new ModelAndView("classes");
        List<ClassRoom> classRooms = classService.getAllClasses();
        for(ClassRoom classRoom:classRooms){
            classRoom.setParalel(parallelsService.getParallelById(classRoom.getParalelId()).getName());
            classRoom.setRoom(roomService.getRoomById(classRoom.getRoomId()).getName());
        }

        modelAndView.addObject("list",classRooms);
        return modelAndView;
    }

    @GetMapping("/rooms")
    public ModelAndView getRoomsInfo() {
        ModelAndView modelAndView=new ModelAndView("rooms_info_admin");
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
        ModelAndView modelAndView=new ModelAndView("pupils");
        List<Pupils> pupils = pupilService.getAllPupils();
        modelAndView.addObject("list",pupils);
        return modelAndView;
    }

    @GetMapping("/personnel")
    public ModelAndView getPersonnelInfo() {
        ModelAndView modelAndView=new ModelAndView("personnel");
        List<Personnel> personnels = personnelService.getAllPersonnel();
        for(Personnel p : personnels){
            p.setQualification(qualificationService.getQualificationById(p.getQUALIFICATIONS_id_qualification()).getName());
        }
        modelAndView.addObject("list",personnels);
        return modelAndView;
    }

    @RequestMapping(value = "/personnel/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePagesDescription(@PathVariable("id") Integer id) {
        personnelService.deletePersonnel(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/personnel/edit/{id}",method = RequestMethod.GET)
    public ModelAndView editPagesDescription(@PathVariable("id") Integer id) {
        Personnel p = personnelService.getPersonnelById(id);
        ModelAndView modelAndView=new ModelAndView("personnel_edit");
        modelAndView.addObject("p",p);
        modelAndView.addObject("q",qualificationService.getAllQualifications());
        return modelAndView;
    }

    @RequestMapping(value = "/personnel/add",method = RequestMethod.GET)
    public ModelAndView addPersonnel() {
        ModelAndView modelAndView=new ModelAndView("personnel_add");
        modelAndView.addObject("q",qualificationService.getAllQualifications());
        return modelAndView;
    }

    @RequestMapping(value = "/personnel/edit",method = RequestMethod.POST)
    public RedirectView editPersonnel(@RequestParam("id") Integer id,@RequestParam String surname,
                                      @RequestParam("name") String name,@RequestParam("midlename") String midlename,
                                      @RequestParam("workPosition") String workPosition,@RequestParam("sex") String sex,
                                      @RequestParam("date_laste_att") String date_laste_att,@RequestParam("tariff_rate") int tariff_rate,
                                      @RequestParam("rank") String rank, @RequestParam("date_employment") String date_employment,
                                      @RequestParam("education") String education, @RequestParam("QUALIFICATIONS_id_qualification") String QUALIFICATIONS_id_qualification) {
        Personnel p = new Personnel();
        p.setQUALIFICATIONS_id_qualification(Integer.parseInt(QUALIFICATIONS_id_qualification.substring(0,1)));
        p.setRank(rank);
        p.setEducation(education);
        p.setTariff_rate(tariff_rate);
        p.setSex(sex);
        p.setWorkPosition(workPosition);
        p.setMidlename(midlename);
        p.setSurname(surname);
        p.setDate_employment(date_employment);
        p.setDate_laste_att(date_laste_att);
        p.setId(id);
        p.setName(name);
        personnelService.updatePersonnel(p);
        return new RedirectView("/admin/personnel");
    }

    @RequestMapping(value = "/personnel/add",method = RequestMethod.POST)
    public RedirectView addPersonnel(@RequestParam String surname,
                                      @RequestParam("name") String name,@RequestParam("midlename") String midlename,
                                      @RequestParam("workPosition") String workPosition,@RequestParam("sex") String sex,
                                      @RequestParam("date_laste_att") String date_laste_att,@RequestParam("tariff_rate") int tariff_rate,
                                      @RequestParam("rank") String rank, @RequestParam("date_employment") String date_employment,
                                      @RequestParam("education") String education, @RequestParam("QUALIFICATIONS_id_qualification") String QUALIFICATIONS_id_qualification) {
        Personnel p = new Personnel();
        p.setQUALIFICATIONS_id_qualification(Integer.parseInt(QUALIFICATIONS_id_qualification.substring(0,1)));
        p.setRank(rank);
        p.setEducation(education);
        p.setTariff_rate(tariff_rate);
        p.setSex(sex);
        p.setWorkPosition(workPosition);
        p.setMidlename(midlename);
        p.setSurname(surname);
        p.setDate_employment(date_employment);
        p.setDate_laste_att(date_laste_att);
        p.setName(name);
        personnelService.addPersonnel(p);
        return new RedirectView("/admin/personnel");
    }

    ///////////////////////////////////
    @RequestMapping(value = "/pupil/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePupil(@PathVariable("id") Integer id) {
        pupilService.deletePupil(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/pupil/edit/{id}",method = RequestMethod.GET)
    public ModelAndView editPupil(@PathVariable("id") Integer id) {
        Pupils p = pupilService.getPupilById(id);
        ModelAndView modelAndView=new ModelAndView("pupil_edit");
        modelAndView.addObject("p",p);
        modelAndView.addObject("q",classService.getAllClasses());
        return modelAndView;
    }

    @RequestMapping(value = "/pupil/add",method = RequestMethod.GET)
    public ModelAndView addPupil() {
        ModelAndView modelAndView=new ModelAndView("pupil_add");
        modelAndView.addObject("q",classService.getAllClasses());
        return modelAndView;
    }

    @RequestMapping(value = "/pupil/edit",method = RequestMethod.POST)
    public RedirectView editPupil(@RequestParam("id") Integer id,@RequestParam String surname,
                                      @RequestParam("name") String name,@RequestParam("midlename") String midlename,
                                      @RequestParam("sex") String sex,
                                        @RequestParam("СlassRoom_id_classes") String classRoom_id_classes) {
        Pupils p = new Pupils();
        p.setСlassRoom_id_classes(Integer.parseInt(classRoom_id_classes.substring(0,1)));
        p.setSex(sex);
        p.setMidlename(midlename);
        p.setSurname(surname);
        p.setId(id);
        p.setName(name);
        pupilService.updatePupil(p);
        return new RedirectView("/admin/pupils");
    }

    @RequestMapping(value = "/pupil/add",method = RequestMethod.POST)
    public RedirectView addPupil(@RequestParam String surname,
                                 @RequestParam("name") String name,@RequestParam("midlename") String midlename,
                                 @RequestParam("sex") String sex,
                                 @RequestParam("СlassRoom_id_classes") String classRoom_id_classes) {

        Pupils p = new Pupils();
        p.setСlassRoom_id_classes(Integer.parseInt(classRoom_id_classes.substring(0,1)));
        p.setSex(sex);
        p.setMidlename(midlename);
        p.setSurname(surname);
        p.setName(name);
        pupilService.addPupil(p);
        return new RedirectView("/admin/pupils");
    }

    ///////////////////////////////////////
    @RequestMapping(value = "/subject/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSubject(@PathVariable("id") Integer id) {
       subjectService.deleteSubject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/subject/edit/{id}",method = RequestMethod.GET)
    public ModelAndView editSubject(@PathVariable("id") Integer id) {
        Subjects p = subjectService.getSubjectById(id);
        ModelAndView modelAndView=new ModelAndView("subject_edit");
        modelAndView.addObject("p",p);
        modelAndView.addObject("q",branchKnowService.getAllBranches());
        return modelAndView;
    }

    @RequestMapping(value = "/subject/add",method = RequestMethod.GET)
    public ModelAndView addSubject() {
        ModelAndView modelAndView=new ModelAndView("subject_add");
        modelAndView.addObject("q",branchKnowService.getAllBranches());
        return modelAndView;
    }

    @RequestMapping(value = "/subject/edit",method = RequestMethod.POST)
    public RedirectView editSubject(@RequestParam("id") Integer id,@RequestParam("name") String name,
                                  @RequestParam("name_subjectCutty") String name_subjectCutty,
                                    @RequestParam("subgroup") Integer subgroup,
                                  @RequestParam("BRANCH_KNOWLEDGE_Id_Branch_knowledge") String BRANCH_KNOWLEDGE_Id_Branch_knowledge) {
        Subjects s = new Subjects();
        s.setId(id);
        s.setName(name);
        s.setName_subjectCutty(name_subjectCutty);
        s.setSubgroup(subgroup);
        s.setBRANCH_KNOWLEDGE_Id_Branch_knowledge(Integer.parseInt(BRANCH_KNOWLEDGE_Id_Branch_knowledge.substring(0,1)));
        subjectService.updateSubject(s);
        return new RedirectView("/admin/subjects");
    }

    @RequestMapping(value = "/subject/add",method = RequestMethod.POST)
    public RedirectView addSubject(@RequestParam("name") String name,
                                   @RequestParam("name_subjectCutty") String name_subjectCutty,
                                   @RequestParam("subgroup") Integer subgroup,
                                   @RequestParam("BRANCH_KNOWLEDGE_Id_Branch_knowledge") String BRANCH_KNOWLEDGE_Id_Branch_knowledge) {

        Subjects s = new Subjects();
        s.setName(name);
        s.setName_subjectCutty(name_subjectCutty);
        s.setSubgroup(subgroup);
        s.setBRANCH_KNOWLEDGE_Id_Branch_knowledge(Integer.parseInt(BRANCH_KNOWLEDGE_Id_Branch_knowledge.substring(0,1)));
        subjectService.addSubject(s);
        return new RedirectView("/admin/subjects");
    }

    ///////////////////////////////////
    @RequestMapping(value = "/class/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteClass(@PathVariable("id") Integer id) {
        classService.deleteClassRoom(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/class/edit/{id}",method = RequestMethod.GET)
    public ModelAndView editClass(@PathVariable("id") Integer id) {
        ClassRoom p = classService.getClassRoomById(id);
        ModelAndView modelAndView=new ModelAndView("class_edit");
        modelAndView.addObject("p",p);
        modelAndView.addObject("q",roomService.getAllRooms());
        modelAndView.addObject("parallel",parallelsService.getAllParallels());
        return modelAndView;
    }

    @RequestMapping(value = "/class/add",method = RequestMethod.GET)
    public ModelAndView addClass() {
        ModelAndView modelAndView=new ModelAndView("class_add");
        modelAndView.addObject("q",roomService.getAllRooms());
        modelAndView.addObject("parallel",parallelsService.getAllParallels());
        return modelAndView;
    }

    @RequestMapping(value = "/class/edit",method = RequestMethod.POST)
    public RedirectView editClass(@RequestParam("id") Integer id,@RequestParam("name") String name,
                                    @RequestParam("change") Integer change,
                                  @RequestParam("profile") String profile,
                                  @RequestParam("limitNumber") Integer limitNumber,
                                  @RequestParam("description") String description,
                                  @RequestParam("roomId") String roomId,
                                  @RequestParam("paralelId") String paralelId) {
        ClassRoom s = new ClassRoom();
        s.setId(id);
        s.setName(name);
        s.setChange(change);
        s.setProfile(profile);
        s.setLimitNumber(limitNumber);
        s.setDescription(description);
        s.setRoomId(Integer.parseInt(roomId.substring(0,1)));
        s.setParalelId(Integer.parseInt(paralelId.substring(0,1)));
        classService.updateClassRoom(s);
        return new RedirectView("/admin/classes");
    }

    @RequestMapping(value = "/class/add",method = RequestMethod.POST)
    public RedirectView addClass(@RequestParam("name") String name,
                                 @RequestParam("change") Integer change,
                                 @RequestParam("profile") String profile,
                                 @RequestParam("limitNumber") Integer limitNumber,
                                 @RequestParam("description") String description,
                                 @RequestParam("roomId") String roomId,
                                 @RequestParam("paralelId") String paralelId) {

        ClassRoom s = new ClassRoom();
        s.setName(name);
        s.setChange(change);
        s.setProfile(profile);
        s.setLimitNumber(limitNumber);
        s.setDescription(description);
        s.setRoomId(Integer.parseInt(roomId.substring(0,1)));
        s.setParalelId(Integer.parseInt(paralelId.substring(0,1)));
        classService.addClass(s);
        return new RedirectView("/admin/classes");
    }



    @GetMapping("/")
    public ModelAndView myInfo() {
        ModelAndView modelAndView=new ModelAndView("admin_info");

        return modelAndView;
    }
}

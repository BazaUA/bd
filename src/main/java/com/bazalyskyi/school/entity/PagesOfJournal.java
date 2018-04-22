package com.bazalyskyi.school.entity;

public class PagesOfJournal {
    private int numberPagesJournal;
    private String pageType;
    private int subgroup_num;
    private String description;
    private int subjectsIdSubject;
    private String subject;
    private int personnelIdEmployee;
    private int classesIdClasses;
    private String classRoom;

    public String getClassRoom() {
        return classRoom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getNumberPagesJournal() {
        return numberPagesJournal;
    }

    public void setNumberPagesJournal(int numberPagesJournal) {
        this.numberPagesJournal = numberPagesJournal;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public int getSubgroup_num() {
        return subgroup_num;
    }

    public void setSubgroup_num(int subgroup_num) {
        this.subgroup_num = subgroup_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSubjectsIdSubject() {
        return subjectsIdSubject;
    }

    public void setSubjectsIdSubject(int subjectsIdSubject) {
        this.subjectsIdSubject = subjectsIdSubject;
    }

    public int getPersonnelIdEmployee() {
        return personnelIdEmployee;
    }

    public void setPersonnelIdEmployee(int personnelIdEmployee) {
        this.personnelIdEmployee = personnelIdEmployee;
    }

    public int getClassesIdClasses() {
        return classesIdClasses;
    }

    public void setClassesIdClasses(int classesIdClasses) {
        this.classesIdClasses = classesIdClasses;
    }
}

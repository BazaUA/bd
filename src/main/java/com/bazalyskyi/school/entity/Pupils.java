package com.bazalyskyi.school.entity;

public class Pupils {
    private int id;
    private String surname;
    private String name;
    private String midlename;
    private String sex;
    private int medal;
    private int СlassRoom_id_classes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMidlename() {
        return midlename;
    }

    public void setMidlename(String midlename) {
        this.midlename = midlename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getMedal() {
        return medal;
    }

    public void setMedal(int medal) {
        this.medal = medal;
    }

    public int getСlassRoom_id_classes() {
        return СlassRoom_id_classes;
    }

    public void setСlassRoom_id_classes(int сlassRoom_id_classes) {
        СlassRoom_id_classes = сlassRoom_id_classes;
    }
}

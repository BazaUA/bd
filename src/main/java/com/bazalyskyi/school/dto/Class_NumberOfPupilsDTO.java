package com.bazalyskyi.school.dto;

public class Class_NumberOfPupilsDTO {
    private int idClass;
    private String classRoom;
    private int count;

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public int getCount() {
        return count;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}

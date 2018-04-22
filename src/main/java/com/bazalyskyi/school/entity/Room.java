package com.bazalyskyi.school.entity;

public class Room {
    private int id;
    private String name;
    private String available;
    private int seats;
    private double area;
    private String specialization;
    private String responsible;
    private int leased;
    private int TYPES_Id_types;
    private boolean isLeased;
    private String type;

    public void setLeased(boolean leased) {
        isLeased = leased;
    }

    public String getType() {
        return type;
    }

    public boolean isLeased() {
        return isLeased;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public int getLeased() {
        return leased;
    }

    public void setLeased(int leased) {
        this.leased = leased;
    }

    public int getTYPES_Id_types() {
        return TYPES_Id_types;
    }

    public void setTYPES_Id_types(int TYPES_Id_types) {
        this.TYPES_Id_types = TYPES_Id_types;
    }
}

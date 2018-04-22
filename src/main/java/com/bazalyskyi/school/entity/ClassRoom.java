package com.bazalyskyi.school.entity;

public class ClassRoom {
    private int id;
    private String name;
    private int change;
    private String profile;
    private int limitNumber;
    private String description;
    private int roomId;
    private int paralelId;
    private String room;
    private String paralel;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getParalel() {
        return paralel;
    }

    public void setParalel(String paralel) {
        this.paralel = paralel;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(int limitNumber) {
        this.limitNumber = limitNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getParalelId() {
        return paralelId;
    }

    public void setParalelId(int paralelId) {
        this.paralelId = paralelId;
    }
}

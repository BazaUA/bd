package com.bazalyskyi.school.entity;

public class UserEntity {
    private String username;
    private String password;
    private int enebled;
    private int fk_id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnebled() {
        return enebled;
    }

    public void setEnebled(int enebled) {
        this.enebled = enebled;
    }

    public int getFk_id() {
        return fk_id;
    }

    public void setFk_id(int fk_id) {
        this.fk_id = fk_id;
    }
}

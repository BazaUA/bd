package com.bazalyskyi.school.entity;

import java.sql.Date;

public class Personnel {
    private int id;
    private String surname;
    private String name;
    private String midlename;
    private String workPosition;
    private String sex;
    private String date_laste_att;
    private int tariff_rate;
    private String rank;
    private String date_employment;
    private String education;
    private int QUALIFICATIONS_id_qualification;
    private String qualification;

    @Override
    public String toString() {
        return "Personnel{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", midlename='" + midlename + '\'' +
                ", workPosition='" + workPosition + '\'' +
                ", sex='" + sex + '\'' +
                ", date_laste_att='" + date_laste_att + '\'' +
                ", tariff_rate=" + tariff_rate +
                ", rank='" + rank + '\'' +
                ", date_employment='" + date_employment + '\'' +
                ", education='" + education + '\'' +
                ", QUALIFICATIONS_id_qualification=" + QUALIFICATIONS_id_qualification +
                ", qualification='" + qualification + '\'' +
                '}';
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

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

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate_laste_att() {
        return date_laste_att;
    }

    public void setDate_laste_att(String date_laste_att) {
        this.date_laste_att = date_laste_att;
    }

    public int getTariff_rate() {
        return tariff_rate;
    }

    public void setTariff_rate(int tariff_rate) {
        this.tariff_rate = tariff_rate;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDate_employment() {
        return date_employment;
    }

    public void setDate_employment(String date_employment) {
        this.date_employment = date_employment;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getQUALIFICATIONS_id_qualification() {
        return QUALIFICATIONS_id_qualification;
    }

    public void setQUALIFICATIONS_id_qualification(int QUALIFICATIONS_id_qualification) {
        this.QUALIFICATIONS_id_qualification = QUALIFICATIONS_id_qualification;
    }
}

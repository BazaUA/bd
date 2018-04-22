package com.bazalyskyi.school.entity;

public class Subjects {
    private  int id;
    private String name;
    private String name_subjectCutty;
    private  int subgroup;
    private int required;
    private  int BRANCH_KNOWLEDGE_Id_Branch_knowledge;
    private String nameOfBranch;
    private boolean value;

    public void setValue(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public String getNameOfBranch() {
        return nameOfBranch;
    }

    public void setNameOfBranch(String nameOfBranch) {
        this.nameOfBranch = nameOfBranch;
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

    public String getName_subjectCutty() {
        return name_subjectCutty;
    }

    public void setName_subjectCutty(String name_subjectCutty) {
        this.name_subjectCutty = name_subjectCutty;
    }

    public int getRequired() {
        return required;
    }

    public int getSubgroup() {
        return subgroup;
    }

    public void setRequired(int required) {
        this.required = required;
    }

    public void setSubgroup(int subgroup) {
        this.subgroup = subgroup;
    }

    public int getBRANCH_KNOWLEDGE_Id_Branch_knowledge() {
        return BRANCH_KNOWLEDGE_Id_Branch_knowledge;
    }

    public void setBRANCH_KNOWLEDGE_Id_Branch_knowledge(int BRANCH_KNOWLEDGE_Id_Branch_knowledge) {
        this.BRANCH_KNOWLEDGE_Id_Branch_knowledge = BRANCH_KNOWLEDGE_Id_Branch_knowledge;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", name_subjectCutty='" + name_subjectCutty + '\'' +
                ", subgroup=" + subgroup +
                ", required=" + required +
                ", BRANCH_KNOWLEDGE_Id_Branch_knowledge=" + BRANCH_KNOWLEDGE_Id_Branch_knowledge +
                '}';
    }
}

package com.project.model;

public class Course {

    // Instance data
    private int id;             // Database ID
    private String cID;         // Course number and subject "CMPSC 101"
    private String cName;       // Course name "Introduction to C++"
    private String cDesc;       // Course description
    private int cCredits;       // Course credits

    // Default constructor
    public Course() {

    }

    public Course(String cID, String cName, String cDesc, int cCredits) {
        this.cID = cID;
        this.cName = cName;
        this.cDesc = cDesc;
        this.cCredits = cCredits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    public int getcCredits() {
        return cCredits;
    }

    public void setcCredits(int cCredits) {
        this.cCredits = cCredits;
    }
}

package com.alejandrachirinos.therealcupid.model;

import com.alejandrachirinos.therealcupid.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;

public class User {
    @Expose
    private long id;

    @Expose
    private String name;

    @Expose
    private String email;

    @Expose
    private int UniversityCode;

    @Expose
    private transient String password;

    @Expose
    private String career;

    @Expose
    private int image;

    @Expose
    private String aboutMe;

    @Expose
    private LinkedList<User> contacts;

    @Expose
    private int age;

    public User(long id, String name, String email, int universityCode, String password, String career, LinkedList<User> contacts, int age) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.UniversityCode = universityCode;
        this.password = password;
        this.career = career;
        this.aboutMe = "";
        this.contacts = contacts;
        this.age = age;
        this.image= R.drawable.default_user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUniversityCode() {
        return UniversityCode;
    }

    public void setUniversityCode(int universityCode) {
        UniversityCode = universityCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public LinkedList<User> getContacts() {
        return contacts;
    }

    public void setContacts(LinkedList<User> contacts) {
        this.contacts = contacts;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

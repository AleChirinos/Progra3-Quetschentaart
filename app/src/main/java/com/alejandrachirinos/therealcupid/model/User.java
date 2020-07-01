package com.alejandrachirinos.therealcupid.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.alejandrachirinos.therealcupid.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;

@Entity(tableName = "User")
public class User {

    @ColumnInfo(name = "username")
    @Expose
    private String username;

    @ColumnInfo(name = "name")
    @Expose
    private String name;

    @ColumnInfo(name = "lastname")
    @Expose
    private String lastname;

    @ColumnInfo(name = "email")
    @Expose
    private String email;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "universityCode")
    @Expose
    private int universityCode;

    @ColumnInfo(name = "password")
    @Expose
    private String password;

    @ColumnInfo(name = "career")
    @Expose
    private String career;

    @ColumnInfo(name = "image")
    @Expose
    private int image;

    @ColumnInfo(name = "hombres")
    @Expose
    private boolean hombres;

    @ColumnInfo(name = "mujeres")
    @Expose
    private boolean mujeres;

    @ColumnInfo(name = "aboutMe")
    @Expose
    private String aboutMe;

    @Ignore
    @Expose
    private LinkedList<User> contacts;

    @ColumnInfo(name = "age")
    @Expose
    private int age;

    @ColumnInfo(name = "photoPath")
    @Expose
    private String photoPath;

    @ColumnInfo(name = "esHombre")
    @Expose
    private boolean esHombre;

    @ColumnInfo(name = "esMujer")
    @Expose
    private boolean esMujer;

    public User(String name, String lastname, String username, String email, int universityCode, String password, String career,
                int age) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.universityCode = universityCode;
        this.password = password;
        this.career = career;
        this.aboutMe = "";
        this.contacts = new LinkedList<>();
        this.age = age;
        this.image = R.drawable.default_user;
        this.mujeres=false;
        this.hombres=false;
        this.esHombre=false;
        this.esMujer=false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUniversityCode() {
        return universityCode;
    }

    public void setUniversityCode(int universityCode) {
        this.universityCode = universityCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isHombres() {
        return hombres;
    }

    public void setHombres(boolean hombres) {
        this.hombres = hombres;
    }

    public boolean isMujeres() {
        return mujeres;
    }

    public void setMujeres(boolean mujeres) {
        this.mujeres = mujeres;
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

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public boolean isEsHombre() {
        return esHombre;
    }

    public void setEsHombre(boolean esHombre) {
        this.esHombre = esHombre;
    }

    public boolean isEsMujer() {
        return esMujer;
    }

    public void setEsMujer(boolean esMujer) {
        this.esMujer = esMujer;
    }

    public void addContact(User user) {
        if (contacts != null) {
            contacts.add(user);
        }
    }

}

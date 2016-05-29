package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 5/15/16.
 */
public class User {

    int user_id;
    String name;
    String password;
    String email;
    String dateOfBirth;
    //double personalSaving;
    int age;
    String gender;
    String city;
    String retirementStatus;
    String freedomFighterStatus;
    String tin;

    public User(int user_id, String name, String password, String email,   int age, String gender, String city, String retirementStatus, String freedomFighterStatus, String tin) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.email = email;
        //this.dateOfBirth = dateOfBirth;
        //this.personalSaving = personalSaving;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.retirementStatus = retirementStatus;
        this.freedomFighterStatus = freedomFighterStatus;
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
/*
    public double getPersonalSaving() {
        return personalSaving;
    }

   // public void setPersonalSaving(double personalSaving) {
        this.personalSaving = personalSaving;
    }
    */


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRetirementStatus() {
        return retirementStatus;
    }

    public void setRetirementStatus(String retirementStatus) {
        this.retirementStatus = retirementStatus;
    }

    public String getFreedomFighterStatus() {
        return freedomFighterStatus;
    }

    public void setFreedomFighterStatus(String freedomFighterStatus) {
        this.freedomFighterStatus = freedomFighterStatus;
    }


    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", name=" + name + ", password=" + password + ", email=" + email
                + ", age=" + age + ", gender=" + gender + ", city=" + city
                + ", retirementStatus=" + retirementStatus + ", freedomFighterStatus=" + freedomFighterStatus + "]";
    }


}

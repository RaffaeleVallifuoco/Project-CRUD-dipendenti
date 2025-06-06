package model;

import java.sql.Date;
import java.time.LocalDate;

public abstract class Persona {

    private int id;
    private String name;
    private String surname;
    private String fc;
    private String city;
    private Date bDay;

    // CONSTRUCTORS

    public Persona() {
    }

    public Persona(int id, String name, String surname, String fc, String city, Date bDay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fc = fc;
        this.city = city;
        this.bDay = bDay;
    }

    // GETTERS & SETTERS

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Persona [id=" + id + ", name=" + name + ", surname=" + surname + ", fc=" + fc + ", city=" + city
                + ", bDay=" + bDay + "]";
    }

}

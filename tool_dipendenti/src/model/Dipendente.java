package model;

import java.sql.Date;

public class Dipendente extends Persona {

    private Double salary;

    / CONSTRUCTORS

    public Dipendente() {
        super();
    }

    public Dipendente(int id, String name, String surname, String fc, String city, Date bDay, Double salary) {
        super(id, name, surname, fc, city, bDay);
        this.salary = salary;
    }

    // GETERS & SETTERS

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    // TO SRING

    @Override
    public String toString() {
        return "Dipendente [salary=" + salary + "]";
    }

    

}

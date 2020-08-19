package ro.jademy.carrental.models;

import java.time.LocalDate;

public class Admin {
    protected String name;
    protected String password;
    protected LocalDate birthDate;
    protected LocalDate yearsOfDriving;

    public Admin(String name, String password, String birthDate, String yearsOfDriving) {
        this.name = name;
        this.password = password;
        this.birthDate = LocalDate.parse(birthDate);
        this.yearsOfDriving = LocalDate.parse(yearsOfDriving);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public int calculateDrivingYears() {
        return LocalDate.now().getYear() - yearsOfDriving.getYear();
    }

}

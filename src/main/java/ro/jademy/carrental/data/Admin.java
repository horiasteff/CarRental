package ro.jademy.carrental.data;

public class Admin{
    protected String name;
    protected String password;
    protected int age;
    protected int yearsOfDriving;

    public Admin(String name, String password, int age,int yearsOfDriving) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.yearsOfDriving = yearsOfDriving;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearsOfDriving() {
        return yearsOfDriving;
    }

    public void setYearsOfDriving(int yearsOfDriving) {
        this.yearsOfDriving = yearsOfDriving;
    }
}

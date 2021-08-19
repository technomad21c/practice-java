package ex013_Stream;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private String dept;
    private Date date;

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

    public String getDept() {
        return dept;
    }

    public Employee(int id, String name, String dept, Date date) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.date = date;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

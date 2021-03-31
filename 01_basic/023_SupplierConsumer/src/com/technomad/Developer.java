package com.technomad;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Developer {
    String name;
    BigDecimal salary;
    LocalDate start;

    public Developer() {

    }

    public Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public String toString() {
        return "Developer -- Name: " + this.name + ", Salary: " + this.salary + ", start: " + this.start;
    }
}

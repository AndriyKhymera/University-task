package com.botscrew.entity;

import com.botscrew.enums.LecturerDegree;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private int salary;

    @Enumerated(EnumType.ORDINAL)
    private LecturerDegree degree;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lector_deparment", joinColumns = @JoinColumn(name = "lectorId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "departmentId", referencedColumnName = "id"))
    private List<Department> deparments;


    //Getters and setters
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LecturerDegree getDegree() {
        return degree;
    }

    public void setDegree(LecturerDegree degree) {
        this.degree = degree;
    }

    public List<Department> getDeparments() {
        return deparments;
    }

    public void setDeparments(List<Department> deparments) {
        this.deparments = deparments;
    }
}

package com.botscrew.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private Lector head;

    @ManyToMany(mappedBy = "deparments")
    private List<Lector> lectors;


    public Department(String name) {
        this.name = name;
    }

    public Department(String name, Lector head, List<Lector> lectors) {
        this.name = name;
        this.head = head;
        this.lectors = lectors;
    }

    //getters and setters
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

    public Optional<Lector> getHead() {
        return Optional.ofNullable(head);
    }

    public void setHead(Lector head) {
        this.head = head;
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }
}

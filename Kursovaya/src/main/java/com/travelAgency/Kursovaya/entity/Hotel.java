package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hotel {
    private @Id @GeneratedValue Long id;
    private String name;
    private String addres;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hotel")
    private List<Room> room;
    public Hotel() {}

    public Hotel(String name, String addres) {
        this.name = name;
        this.addres = addres;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public String getAddres() {
        return addres;
    }

    public List<Room> getRoom() {
        return room;
    }
}

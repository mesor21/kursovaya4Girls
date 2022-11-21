package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Hotel {
    private @Id @GeneratedValue Long id;
    private String Name;
    private String addres;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hotel")
    private Set<Room> room;
    public Hotel() {}
}

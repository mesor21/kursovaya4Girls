package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;

@Entity
public class Room {
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Hotel hotel;
    private @Id @GeneratedValue Long id;
    private int Number;

    public Room(){}
}

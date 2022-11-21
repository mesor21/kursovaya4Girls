package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
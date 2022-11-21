package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Room, Long> {
}

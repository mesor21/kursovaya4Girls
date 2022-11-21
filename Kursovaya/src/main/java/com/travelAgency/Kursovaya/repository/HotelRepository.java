package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
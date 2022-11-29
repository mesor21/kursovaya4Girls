
package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findByName(String Name);
}

package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserSystem,Long>{
    UserSystem findByLogin(String login);
}


package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserSystem,Long>{
    UserSystem findByUsername(String login);

}

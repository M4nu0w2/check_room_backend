package com.example.check_room.Repository;

import com.example.check_room.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

@Query(value = "SELECT u from User u where u.id= :userId")
    User findUserById(@Param("userId") Long userId);

    boolean existsUserById(Long id);
}

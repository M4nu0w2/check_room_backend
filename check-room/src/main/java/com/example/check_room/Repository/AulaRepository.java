package com.example.check_room.Repository;

import com.example.check_room.Entity.Aula;
import com.example.check_room.Entity.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    @Query(value = "SELECT u from Aula u where u.id= :aulaId")
    Aula findAulaById(@Param("aulaId") Long aulaId);

    boolean existsAulaById(Long id);
}

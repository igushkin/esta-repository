package com.example.estarepository.activity.repository;

import com.example.estarepository.activity.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("SELECT a FROM Activity a " +
            "WHERE (:text IS NULL or a.title like CONCAT('%',:text,'%'))")
    Page<Activity> findAllActivities(@Param("text") String text, Pageable pageable);
}

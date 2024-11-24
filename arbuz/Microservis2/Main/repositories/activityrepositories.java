package com.example.service2.Repositories;

import com.example.service2.DatabaseEntities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
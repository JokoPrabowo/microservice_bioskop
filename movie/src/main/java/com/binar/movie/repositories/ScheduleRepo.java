package com.binar.movie.repositories;

import com.binar.movie.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByFilmCode(String code);
}

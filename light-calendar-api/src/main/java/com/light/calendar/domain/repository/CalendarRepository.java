package com.light.calendar.domain.repository;

import com.light.calendar.domain.entity.Calendar;
import com.light.calendar.domain.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    Optional<Calendar> findByIdAndStatus(Long id, Status status);
}

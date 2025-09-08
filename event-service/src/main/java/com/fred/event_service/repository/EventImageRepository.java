package com.fred.event_service.repository;

import com.fred.event_service.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventImageRepository extends JpaRepository<Event, Integer> {
}

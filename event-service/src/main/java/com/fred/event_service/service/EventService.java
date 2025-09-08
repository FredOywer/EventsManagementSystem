package com.fred.event_service.service;

import com.fred.event_service.model.Event;
import com.fred.event_service.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    EventRepository eventRepository;

    EventService(EventRepository eventRepo){
        this.eventRepository = eventRepo;
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Optional<Event> getEvent(Integer eventId){
        return eventRepository.findById(eventId);
    }

    public void deleteEvent(Integer eventId){
        eventRepository.deleteById(eventId);
    }
}

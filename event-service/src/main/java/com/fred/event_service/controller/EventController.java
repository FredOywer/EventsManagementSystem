package com.fred.event_service.controller;

import com.fred.event_service.model.Event;
import com.fred.event_service.model.EventRequest;
import com.fred.event_service.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/events")
public class EventController {
    final EventService eventService;

    EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable Integer id){
        Event event = eventService.getEvent(id).orElse(null);
        if (event != null){
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventRequest eventRequest){

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id){
        Event event = eventService.getEvent(id).orElse(null);
        if (event != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

package com.fred.event_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fred.event_service.model.Event;
import com.fred.event_service.model.EventImage;
import com.fred.event_service.model.EventRequest;
import com.fred.event_service.repository.EventImageRepository;
import com.fred.event_service.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    final EventRepository eventRepository;
    final FileService fileService;
    final EventImageRepository imageRepository;

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Optional<Event> getEvent(Integer eventId){
        return eventRepository.findById(eventId);
    }

    @Transactional
    public Event createEvent(EventRequest request){
        ObjectMapper objectMapper = new ObjectMapper();
        Event savedEvent = eventRepository.save(objectMapper.convertValue(request, Event.class));

        String path = fileService.saveImage(request.getImage());
        //todo save more event images

        EventImage eventImage = new EventImage();
        eventImage.setEventId(savedEvent.getId());
        eventImage.setImageUri(path);
        imageRepository.save(eventImage);

        return savedEvent;
    }

    public void deleteEvent(Integer eventId){
        //change status
        eventRepository.deleteById(eventId);
    }
}

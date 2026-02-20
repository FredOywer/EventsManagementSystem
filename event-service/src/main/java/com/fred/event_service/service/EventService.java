package com.fred.event_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fred.event_service.model.ApiResponse;
import com.fred.event_service.model.Event;
import com.fred.event_service.model.EventImage;
import com.fred.event_service.model.EventRequest;
import com.fred.event_service.repository.EventImageRepository;
import com.fred.event_service.repository.EventRepository;
import com.fred.event_service.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

    public Optional<Event> getEvent(Long eventId){
        return eventRepository.findById(eventId);
    }

    public Event createEvent(EventRequest request){
        ObjectMapper objectMapper = new ObjectMapper();
        return eventRepository.save(objectMapper.convertValue(request, Event.class));
    }

    public void deleteEvent(Long eventId){
        //todo change status instead
        eventRepository.deleteById(eventId);
    }

    public ApiResponse uploadEventImage(Long id, MultipartFile file){
        ApiResponse apiResponse = new ApiResponse();

        Event event = getEvent(id).orElse(null);
        if (event == null){
            apiResponse.setResultCode(Constants.CODE_500);
            apiResponse.setMessage("Event not found");
            return apiResponse;
        }

        String path = fileService.saveImage(file);
        if (path != null){
            apiResponse.setResultCode(Constants.CODE_500);
            apiResponse.setMessage("Error occurred while saving image");
            return apiResponse;
        }

        EventImage eventImage = new EventImage();
        eventImage.setEventId(event.getId());
        eventImage.setImageUri(path);
        imageRepository.save(eventImage);

        apiResponse.setResultCode(Constants.CODE_200);
        apiResponse.setData(path);
        return apiResponse;
    }
}

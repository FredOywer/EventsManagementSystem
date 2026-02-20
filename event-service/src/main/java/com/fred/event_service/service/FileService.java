package com.fred.event_service.service;

import com.fred.event_service.config.AppConfig;
import com.fred.event_service.util.Common;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {

    final AppConfig cfg;

    public String saveImage(MultipartFile file){
        log.info("uploading image");
        try {
            byte[] imageBytes = file.getBytes();
            String originalName = file.getOriginalFilename();
            String timestamp = Common.getTimestamp();

            Path path = Paths.get(cfg.getEventImagePath() + originalName + timestamp);
            Files.createDirectories(path.getParent());
            Files.write(path, imageBytes);

            log.info("image uploaded successful");
            return path.toString();
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }
    }

}

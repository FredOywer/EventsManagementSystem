package com.fred.event_service.service;

import com.fred.event_service.config.AppConfig;
import com.fred.event_service.util.Common;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class FileService {

    final AppConfig cfg;

    public String saveImage(MultipartFile file){
        try {
            byte[] imageBytes = file.getBytes();
            String originalName = file.getOriginalFilename();
            String timestamp = Common.getTimestamp();

            Path path = Paths.get(cfg.getEventImagePath() + originalName + timestamp);
            Files.createDirectories(path.getParent());
            Files.write(path, imageBytes);
            return path.toString();
//            return path.toAbsolutePath().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

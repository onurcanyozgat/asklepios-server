package com.asklepios.asklepios_server.contact.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    private String uploadDir;

    public FileServiceImpl( @Value("${app.file.upload}") String uploadDir) {
        this.uploadDir = uploadDir;
        Path path = Paths.get(uploadDir);
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new RuntimeException("Could not create storage directory.", e);
        }
    }

    @Override
    public List<String> processFiles(MultipartFile[] files, String directoryName) {
        List<String> filePathList = new ArrayList<>();
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                try {
                    filePathList.add(store(file, directoryName));
                } catch (Exception e) {
                    log.error("An error occurred while processing contact form files.", e);
                }
            }
        }
        return filePathList;
    }

    private String store(MultipartFile file, String directoryName) {
        String uploadDirWithIdentifier = uploadDir + "/" + directoryName;
        createDirectoryByName(uploadDirWithIdentifier);
        String fileName = file.getOriginalFilename();
        Path targetLocation = Paths.get(uploadDirWithIdentifier).resolve(fileName);
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return targetLocation.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file.", e);
        }
    }

    private void createDirectoryByName(String directoryName) {
        try {
            Path path = Paths.get(directoryName);
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new RuntimeException("Could not create storage directory.", e);
        }
    }
}


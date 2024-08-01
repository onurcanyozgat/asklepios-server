package com.asklepios.asklepios_server.contact.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    List<String> processFiles(MultipartFile[] files, String directoryName);

}

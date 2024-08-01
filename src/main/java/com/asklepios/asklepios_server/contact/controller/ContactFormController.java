package com.asklepios.asklepios_server.contact.controller;

import com.asklepios.asklepios_server.contact.data.dto.ContactFormDto;
import com.asklepios.asklepios_server.contact.service.ContactFormService;
import com.asklepios.asklepios_server.contact.service.FileService;
import com.asklepios.asklepios_server.util.exception.ValidationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("api/v1/contact")
@Tag(name = "Contact Form Management")
public class ContactFormController {

    private final ContactFormService contactFormService;

    private final FileService fileService;

    @Autowired
    public ContactFormController(ContactFormService contactFormService, FileService fileService) {
        this.contactFormService = contactFormService;
        this.fileService = fileService;
    }

    @Operation(description = "Send contact form", summary = "Send contact form", responses = {@ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = "multipart/form-data")
    public ResponseEntity<ContactFormDto> create(
            @Parameter(name = "request", description = "Parameters of the contact form", required = true) @RequestPart("document") String contactForm,
            @RequestPart("files") MultipartFile[] files) {
        try {
            ContactFormDto contactFormDto = deserializeDocumentObject(contactForm);
            List<String> filePaths = fileService.processFiles(files, getDirectoryName(contactFormDto));
            contactFormDto.setImagePaths(filePaths);
            return ResponseEntity.ok(contactFormService.save(contactFormDto));
        } catch (ValidationException ex){
            return ResponseEntity.badRequest().build();
        } catch (Exception ex) {
            log.error("An error occurred while sending contact form.", ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    private ContactFormDto deserializeDocumentObject(String contactForm) throws ValidationException {
        ContactFormDto dto;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dto = objectMapper.readValue(contactForm, ContactFormDto.class);
        } catch (Exception e) {
            log.error("An error occurred while converting document object to ContactFormDto.", e);
            throw new ValidationException("Invalid JSON format");
        }
        return dto;
    }

    private String getDirectoryName(ContactFormDto contactFormDto) {
        return contactFormDto.getFirstname() + "_" + contactFormDto.getLastname();
    }
}

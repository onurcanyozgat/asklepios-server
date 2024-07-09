package com.asklepios.asklepios_server.contact.controller;

import com.asklepios.asklepios_server.contact.data.dto.ContactFormDto;
import com.asklepios.asklepios_server.contact.service.ContactFormService;
import com.asklepios.asklepios_server.doctor.data.dto.DoctorDto;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("api/v1/contact")
@Tag(name = "Contact Form Management")
public class ContactFormController {

    private final ContactFormService contactFormService;

    @Autowired
    public ContactFormController(ContactFormService contactFormService) {this.contactFormService = contactFormService;}

    @Operation(description = "Send contact form", summary = "Send contact form", responses = {@ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactFormDto> create(
            @Parameter(name = "request", description = "Parameters of the contact form", required = true) @RequestBody ContactFormDto contactFormDto) {
        try {
            return ResponseEntity.ok(contactFormService.save(contactFormDto));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

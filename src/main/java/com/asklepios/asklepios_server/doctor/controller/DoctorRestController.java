package com.asklepios.asklepios_server.doctor.controller;

import com.asklepios.asklepios_server.doctor.data.dto.DoctorDto;
import com.asklepios.asklepios_server.doctor.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("api/v1/doctor")
@Tag(name = "Doctor Management")
public class DoctorRestController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorRestController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Operation(description = "Create the doctor", summary = "Create the doctor", responses = {@ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorDto> create(
            @Parameter(name = "request", description = "Parameters of the doctor info", required = true) @RequestBody DoctorDto doctorDto) {
        try {
            return ResponseEntity.ok(doctorService.create(doctorDto));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(description = "Update the doctor info", summary = "Update the doctor info", responses = {@ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Id can not be null", responseCode = "400"),
            @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(
            @Parameter(name = "request", description = "Parameters of the doctor info.", required = true) @RequestBody DoctorDto doctorDto) {
        try {
            if(doctorDto.getId() <= 0) {
                return ResponseEntity.badRequest().body("Id can not be null");
            }
            return ResponseEntity.ok(doctorService.create(doctorDto));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(description = "Get all doctors", summary = "Get all doctors", responses = {@ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DoctorDto>> getAll() {
        try {
            return ResponseEntity.ok(doctorService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

}

package com.asklepios.asklepios_server.clinic.controller;

import com.asklepios.asklepios_server.clinic.data.dto.ClinicDto;
import com.asklepios.asklepios_server.clinic.service.ClinicService;
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
@RequestMapping("api/v1/clinic")
@Tag(name = "Clinic Management")
public class ClinicRestController {
    private final ClinicService clinicService;

    @Autowired
    public ClinicRestController(ClinicService clinicService) {this.clinicService = clinicService;}

    @Operation(description = "Create the clinic", summary = "Create the clinic",
               responses = {@ApiResponse(description = "Success", responseCode = "200"),
                       @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClinicDto> create(
            @Parameter(name = "request", description = "Parameters of the clinic info", required = true) @RequestBody ClinicDto clinicDto) {
        try {
            return ResponseEntity.ok(clinicService.create(clinicDto));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(description = "Update the clinic info", summary = "Update the clinic info",
               responses = {@ApiResponse(description = "Success", responseCode = "200"),
                       @ApiResponse(description = "Id can not be null", responseCode = "400"),
                       @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(
            @Parameter(name = "request", description = "Parameters of the doctor info.", required = true) @RequestBody ClinicDto clinicDto) {
        try {
            if (clinicDto.getId() <= 0) {
                return ResponseEntity.badRequest().body("Id can not be null");
            }
            return ResponseEntity.ok(clinicService.create(clinicDto));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(description = "Get all clinics", summary = "Get all clinics", responses = {@ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403")})
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClinicDto>> getAll() {
        try {
            return ResponseEntity.ok(clinicService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

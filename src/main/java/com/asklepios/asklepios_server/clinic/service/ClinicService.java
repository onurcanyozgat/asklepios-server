package com.asklepios.asklepios_server.clinic.service;

import com.asklepios.asklepios_server.clinic.data.dto.ClinicDto;

import java.util.List;
import java.util.NoSuchElementException;

public interface ClinicService {
    ClinicDto create(ClinicDto clinicDto);

    ClinicDto findById(Long id) throws NoSuchElementException;

    List<ClinicDto> getAll();

    List<ClinicDto> getPopular();
}

package com.asklepios.asklepios_server.doctor.service;

import com.asklepios.asklepios_server.doctor.data.dto.DoctorDto;

import java.util.List;
import java.util.NoSuchElementException;

public interface DoctorService {
    DoctorDto create(DoctorDto doctorDto);

    DoctorDto findById(Long id) throws NoSuchElementException;

    List<DoctorDto> getAll();

    List<DoctorDto> getPopular();
}


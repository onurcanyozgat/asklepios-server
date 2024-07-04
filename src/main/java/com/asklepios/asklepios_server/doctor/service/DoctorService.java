package com.asklepios.asklepios_server.doctor.service;

import com.asklepios.asklepios_server.doctor.controller.data.dto.DoctorDto;
import com.asklepios.asklepios_server.doctor.controller.data.entity.DoctorEntity;

import java.util.List;

public interface DoctorService {
    DoctorDto create(DoctorDto doctorDto);

    List<DoctorEntity> getPopular();
}


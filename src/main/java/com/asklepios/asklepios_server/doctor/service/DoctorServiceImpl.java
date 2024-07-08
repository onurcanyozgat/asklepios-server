package com.asklepios.asklepios_server.doctor.service;

import com.asklepios.asklepios_server.doctor.data.dto.DoctorDto;
import com.asklepios.asklepios_server.doctor.converter.DoctorConverter;
import com.asklepios.asklepios_server.doctor.data.entity.DoctorEntity;
import com.asklepios.asklepios_server.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    private final DoctorConverter converter;

    @Autowired
    public DoctorServiceImpl(DoctorRepository repository, DoctorConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public DoctorDto create(DoctorDto doctorDto) {
        DoctorEntity entity = converter.toEntity(doctorDto);
        DoctorEntity savedEntity = repository.save(entity);
        return converter.toDto(savedEntity);
    }

    @Override
    public DoctorDto findById(Long id) throws NoSuchElementException {
        Optional<DoctorEntity> optionalDoctorEntity = repository.findById(id);
        DoctorEntity entity = optionalDoctorEntity.orElseThrow();
        return converter.toDto(entity);
    }

    @Override
    public List<DoctorDto> getAll() {
        List<DoctorEntity> allDoctorEntities = repository.findAll();
        return allDoctorEntities.stream().map(converter::toDto).collect(Collectors.toList());
    }

    @Override
    public List<DoctorDto> getPopular() {
        // TODO not implemented yet
        List<DoctorEntity> allDoctorEntities = repository.findAll();
        return allDoctorEntities.stream().map(converter::toDto).collect(Collectors.toList());
    }
}

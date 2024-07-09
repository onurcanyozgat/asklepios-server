package com.asklepios.asklepios_server.clinic.service;

import com.asklepios.asklepios_server.clinic.converter.ClinicConverter;
import com.asklepios.asklepios_server.clinic.data.dto.ClinicDto;
import com.asklepios.asklepios_server.clinic.data.entity.ClinicEntity;
import com.asklepios.asklepios_server.clinic.repository.ClinicRepository;
import com.asklepios.asklepios_server.doctor.data.entity.DoctorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepository repository;

    @Autowired
    public ClinicServiceImpl(ClinicRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClinicDto create(ClinicDto clinicDto) {
        ClinicEntity entity = ClinicConverter.toEntity(clinicDto);
        ClinicEntity savedEntity = repository.save(entity);
        return ClinicConverter.toDto(savedEntity);
    }

    @Override
    public ClinicDto findById(Long id) throws NoSuchElementException {
        Optional<ClinicEntity> optionalClinicEntity = repository.findById(id);
        ClinicEntity entity = optionalClinicEntity.orElseThrow();
        return ClinicConverter.toDto(entity);
    }

    @Override
    public List<ClinicDto> getAll() {
        List<ClinicEntity> allClinicEntities = repository.findAll();
        return allClinicEntities.stream().map(ClinicConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ClinicDto> getPopular() {
        // TODO not implemented yet
        List<ClinicEntity> allClinicEntities = repository.findAll();
        return allClinicEntities.stream().map(ClinicConverter::toDto).collect(Collectors.toList());
    }
}

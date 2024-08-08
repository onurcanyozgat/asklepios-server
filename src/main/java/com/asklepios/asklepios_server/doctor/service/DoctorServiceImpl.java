package com.asklepios.asklepios_server.doctor.service;

import com.asklepios.asklepios_server.doctor.converter.DoctorConverter;
import com.asklepios.asklepios_server.doctor.data.dto.DoctorDto;
import com.asklepios.asklepios_server.doctor.data.entity.DoctorEntity;
import com.asklepios.asklepios_server.doctor.repository.DoctorRepository;
import com.asklepios.asklepios_server.search.DoctorSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository repository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public DoctorDto create(DoctorDto doctorDto) {
        DoctorEntity entity = DoctorConverter.toEntity(doctorDto);
        DoctorEntity savedEntity = repository.save(entity);
        return DoctorConverter.toDto(savedEntity);
    }

    @Override
    public DoctorDto findById(Long id) throws NoSuchElementException {
        Optional<DoctorEntity> optionalDoctorEntity = repository.findById(id);
        DoctorEntity entity = optionalDoctorEntity.orElseThrow();
        return DoctorConverter.toDto(entity);
    }

    @Override
    public List<DoctorDto> getAll() {
        List<DoctorEntity> allDoctorEntities = repository.findAll();
        return allDoctorEntities.stream().map(DoctorConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public List<DoctorDto> getPopular() {
        // TODO not implemented yet
        List<DoctorEntity> allDoctorEntities = repository.findAll();
        return allDoctorEntities.stream().map(DoctorConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<DoctorDto> search(String searchCriteria, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<DoctorEntity> spec = Specification.where(null);
        if (searchCriteria != null && !searchCriteria.isEmpty()) {
            spec = spec.or(DoctorSpecification.name(searchCriteria));
            spec = spec.or(DoctorSpecification.specialization(searchCriteria));
            spec = spec.or(DoctorSpecification.city(searchCriteria));
        }
        Page<DoctorEntity> pageableDoctorEntities = repository.findAll(spec, pageable);
        return pageableDoctorEntities.map(DoctorConverter::toDto);
    }
}

package com.asklepios.asklepios_server.doctor.converter;

import com.asklepios.asklepios_server.doctor.data.dto.EducationDto;
import com.asklepios.asklepios_server.doctor.data.entity.EducationEntity;
import org.springframework.stereotype.Component;

@Component
public class EducationConverter {
    public EducationDto toDto(EducationEntity entity) {
        EducationDto dto = new EducationDto();
        dto.setId(entity.getId());
        dto.setStartYear(entity.getStartYear());
        dto.setGraduateYear(entity.getGraduateYear());
        dto.setDegree(entity.getDegree());
        dto.setDepartment(entity.getDepartment());
        dto.setUniversity(entity.getUniversity());
        dto.setCountry(entity.getCountry());
        return dto;
    }

    public EducationEntity toEntity(EducationDto dto) {
        EducationEntity entity = new EducationEntity();
        entity.setId(dto.getId());
        entity.setStartYear(dto.getStartYear());
        entity.setGraduateYear(dto.getGraduateYear());
        entity.setDegree(dto.getDegree());
        entity.setDepartment(dto.getDepartment());
        entity.setUniversity(dto.getUniversity());
        entity.setCountry(dto.getCountry());
        return entity;
    }

}

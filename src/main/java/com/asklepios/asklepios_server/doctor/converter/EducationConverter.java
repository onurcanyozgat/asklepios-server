package com.asklepios.asklepios_server.doctor.converter;

import com.asklepios.asklepios_server.doctor.data.dto.EducationDto;
import com.asklepios.asklepios_server.doctor.data.entity.EducationEntity;
import org.springframework.stereotype.Component;

@Component
public class EducationConverter {
    public EducationDto toDto(EducationEntity entity) {
        EducationDto dto = new EducationDto();
        return dto;
    }

    public EducationEntity toEntity(EducationDto dto) {
        EducationEntity entity = new EducationEntity();
        return entity;
    }

}

package com.asklepios.asklepios_server.clinic.converter;

import com.asklepios.asklepios_server.clinic.data.dto.ClinicDto;
import com.asklepios.asklepios_server.clinic.data.entity.ClinicEntity;
import org.springframework.stereotype.Component;

@Component
public class ClinicConverter {
    public ClinicDto toDto(ClinicEntity entity) {
        ClinicDto dto = new ClinicDto();
        return dto;
    }

    public ClinicEntity toEntity(ClinicDto dto) {
        ClinicEntity entity = new ClinicEntity();
        return entity;
    }
}

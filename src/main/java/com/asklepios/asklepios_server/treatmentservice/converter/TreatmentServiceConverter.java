package com.asklepios.asklepios_server.treatmentservice.converter;

import com.asklepios.asklepios_server.treatmentservice.data.dto.TreatmentServiceDto;
import com.asklepios.asklepios_server.treatmentservice.data.entity.TreatmentServiceEntity;
import org.springframework.stereotype.Component;

@Component
public class TreatmentServiceConverter {
    public TreatmentServiceDto toDto(TreatmentServiceEntity entity) {
        TreatmentServiceDto dto = new TreatmentServiceDto();
        dto.setId(entity.getId());
        dto.setTreatment(entity.getTreatment());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setDurationInMinutes(entity.getDurationInMinutes());
        return dto;
    }

    public TreatmentServiceEntity toEntity(TreatmentServiceDto dto) {
        TreatmentServiceEntity entity = new TreatmentServiceEntity();
        entity.setId(dto.getId());
        entity.setTreatment(dto.getTreatment());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setDurationInMinutes(entity.getDurationInMinutes());
        return entity;
    }
}

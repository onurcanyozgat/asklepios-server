package com.asklepios.asklepios_server.treatmentservice.converter;

import com.asklepios.asklepios_server.treatmentservice.data.dto.TreatmentServiceDto;
import com.asklepios.asklepios_server.treatmentservice.data.entity.TreatmentServiceEntity;

public class TreatmentServiceConverter {

    public static TreatmentServiceDto toDto(TreatmentServiceEntity entity) {
        TreatmentServiceDto dto = new TreatmentServiceDto();
        dto.setId(entity.getId());
        dto.setTreatment(entity.getTreatment());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setDurationInMinutes(entity.getDurationInMinutes());
        return dto;
    }

    public static TreatmentServiceEntity toEntity(TreatmentServiceDto dto) {
        TreatmentServiceEntity entity = new TreatmentServiceEntity();
        entity.setId(dto.getId());
        entity.setTreatment(dto.getTreatment());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setDurationInMinutes(entity.getDurationInMinutes());
        return entity;
    }
}

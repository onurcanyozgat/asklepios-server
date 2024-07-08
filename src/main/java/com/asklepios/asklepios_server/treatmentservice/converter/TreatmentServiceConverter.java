package com.asklepios.asklepios_server.treatmentservice.converter;

import com.asklepios.asklepios_server.treatmentservice.data.entity.TreatmentServiceDto;
import com.asklepios.asklepios_server.treatmentservice.data.entity.TreatmentServiceEntity;
import org.springframework.stereotype.Component;

@Component
public class TreatmentServiceConverter {
    public TreatmentServiceDto toDto(TreatmentServiceEntity entity) {
        TreatmentServiceDto dto = new TreatmentServiceDto();
        return dto;
    }

    public TreatmentServiceEntity toEntity(TreatmentServiceDto dto) {
        TreatmentServiceEntity entity = new TreatmentServiceEntity();
        return entity;
    }
}

package com.asklepios.asklepios_server.doctor.converter;

import com.asklepios.asklepios_server.doctor.data.dto.CareerDto;
import com.asklepios.asklepios_server.doctor.data.entity.CareerEntity;
import org.springframework.stereotype.Component;

@Component
public class CareerConverter {
    public CareerDto toDto(CareerEntity entity) {
        CareerDto dto = new CareerDto();
        dto.setId(entity.getId());
        dto.setStartYear(entity.getStartYear());
        dto.setEndYear(entity.getEndYear());
        dto.setTitle(entity.getTitle());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCountry(entity.getCountry());
        return dto;
    }

    public CareerEntity toEntity(CareerDto dto) {
        CareerEntity entity = new CareerEntity();
        entity.setId(dto.getId());
        entity.setStartYear(dto.getStartYear());
        entity.setEndYear(dto.getEndYear());
        entity.setTitle(dto.getTitle());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCountry(dto.getCountry());
        return entity;
    }
}

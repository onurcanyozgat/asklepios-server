package com.asklepios.asklepios_server.doctor.converter;

import com.asklepios.asklepios_server.doctor.data.dto.CareerDto;
import com.asklepios.asklepios_server.doctor.data.entity.CareerEntity;
import org.springframework.stereotype.Component;

@Component
public class CareerConverter {
    public CareerDto toDto(CareerEntity entity) {
        CareerDto dto = new CareerDto();
        return dto;
    }

    public CareerEntity toEntity(CareerDto dto) {
        CareerEntity entity = new CareerEntity();
        return entity;
    }
}

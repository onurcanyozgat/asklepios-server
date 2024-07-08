package com.asklepios.asklepios_server.util.converter;

import com.asklepios.asklepios_server.util.data.dto.AddressDto;
import com.asklepios.asklepios_server.util.data.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {
    public AddressDto toDto(AddressEntity entity) {
        AddressDto dto = new AddressDto();
        return dto;
    }

    public AddressEntity toEntity(AddressDto dto) {
        AddressEntity entity = new AddressEntity();
        return entity;
    }
}

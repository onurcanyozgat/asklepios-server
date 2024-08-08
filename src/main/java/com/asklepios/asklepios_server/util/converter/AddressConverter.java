package com.asklepios.asklepios_server.util.converter;

import com.asklepios.asklepios_server.util.data.dto.AddressDto;
import com.asklepios.asklepios_server.util.data.entity.AddressEntity;

public class AddressConverter {
    public static AddressDto toDto(AddressEntity entity) {
        AddressDto dto = new AddressDto();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAddressContent());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        return dto;
    }

    public static AddressEntity toEntity(AddressDto dto) {
        AddressEntity entity = new AddressEntity();
        entity.setId(dto.getId());
        entity.setAddressContent(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        return entity;
    }
}

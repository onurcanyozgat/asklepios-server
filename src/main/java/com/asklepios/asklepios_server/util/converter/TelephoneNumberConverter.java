package com.asklepios.asklepios_server.util.converter;

import com.asklepios.asklepios_server.util.data.dto.TelephoneNumberDto;
import com.asklepios.asklepios_server.util.data.entity.TelephoneNumberEntity;
import org.springframework.stereotype.Component;

@Component
public class TelephoneNumberConverter {
    public TelephoneNumberDto toDto(TelephoneNumberEntity entity) {
        TelephoneNumberDto dto = new TelephoneNumberDto();
        dto.setId(entity.getId());
        dto.setCountryCode(entity.getCountryCode());
        dto.setNumber(entity.getNumber());
        return dto;
    }

    public TelephoneNumberEntity toEntity(TelephoneNumberDto dto) {
        TelephoneNumberEntity entity = new TelephoneNumberEntity();
        entity.setId(dto.getId());
        entity.setCountryCode(dto.getCountryCode());
        entity.setNumber(entity.getNumber());
        return entity;
    }
}

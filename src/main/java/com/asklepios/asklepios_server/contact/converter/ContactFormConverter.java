package com.asklepios.asklepios_server.contact.converter;

import com.asklepios.asklepios_server.contact.data.dto.ContactFormDto;
import com.asklepios.asklepios_server.contact.data.entity.ContactFormEntity;

import java.util.Date;

public class ContactFormConverter {
    public static ContactFormDto toDto(ContactFormEntity entity) {
        ContactFormDto dto = new ContactFormDto();
        dto.setId(entity.getId());
        dto.setTreatment(entity.getTreatment());
        dto.setPatient(entity.getPatient());
        dto.setTime(entity.getTime());
        dto.setCommunicationType(entity.getCommunicationType());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public static ContactFormEntity toEntity(ContactFormDto dto) {
        ContactFormEntity entity = new ContactFormEntity();
        entity.setId(dto.getId());
        entity.setTreatment(dto.getTreatment());
        entity.setPatient(dto.getPatient());
        entity.setTime(dto.getTime());
        entity.setCommunicationType(dto.getCommunicationType());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setEmail(dto.getEmail());
        entity.setCreatedAt(new Date(System.currentTimeMillis()));
        return entity;
    }

}

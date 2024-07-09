package com.asklepios.asklepios_server.clinic.converter;

import com.asklepios.asklepios_server.clinic.data.dto.ClinicDto;
import com.asklepios.asklepios_server.clinic.data.entity.ClinicEntity;
import com.asklepios.asklepios_server.doctor.converter.DoctorConverter;
import com.asklepios.asklepios_server.treatmentservice.converter.TreatmentServiceConverter;
import com.asklepios.asklepios_server.util.converter.AddressConverter;

import java.util.stream.Collectors;

public class ClinicConverter {
    public static ClinicDto toDto(ClinicEntity entity) {
        ClinicDto dto = new ClinicDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(AddressConverter.toDto(entity.getAddress()));
        dto.setContactInfo(entity.getContactInfo());
        dto.setDoctors(entity.getDoctors().stream().map(DoctorConverter::toDto).collect(Collectors.toList()));
        dto.setTreatments(entity.getTreatments().stream().map(TreatmentServiceConverter::toDto).collect(Collectors.toList()));
        return dto;
    }

    public static ClinicEntity toEntity(ClinicDto dto) {
        ClinicEntity entity = new ClinicEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(AddressConverter.toEntity(dto.getAddress()));
        entity.setContactInfo(dto.getContactInfo());
        entity.setDoctors(dto.getDoctors().stream().map(DoctorConverter::toEntity).collect(Collectors.toSet()));
        entity.setTreatments(dto.getTreatments().stream().map(TreatmentServiceConverter::toEntity).collect(Collectors.toSet()));
        return entity;
    }
}

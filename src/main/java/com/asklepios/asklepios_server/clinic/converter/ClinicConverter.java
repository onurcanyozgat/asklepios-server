package com.asklepios.asklepios_server.clinic.converter;

import com.asklepios.asklepios_server.clinic.data.dto.ClinicDto;
import com.asklepios.asklepios_server.clinic.data.entity.ClinicEntity;
import com.asklepios.asklepios_server.doctor.converter.DoctorConverter;
import com.asklepios.asklepios_server.treatmentservice.converter.TreatmentServiceConverter;
import com.asklepios.asklepios_server.util.converter.AddressConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ClinicConverter {

    private final AddressConverter addressConverter;

    private final DoctorConverter doctorConverter;

    private final TreatmentServiceConverter treatmentServiceConverter;

    @Autowired
    public ClinicConverter(AddressConverter addressConverter, DoctorConverter doctorConverter, TreatmentServiceConverter treatmentServiceConverter) {
        this.addressConverter = addressConverter;
        this.doctorConverter = doctorConverter;
        this.treatmentServiceConverter = treatmentServiceConverter;
    }

    public ClinicDto toDto(ClinicEntity entity) {
        ClinicDto dto = new ClinicDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(addressConverter.toDto(entity.getAddress()));
        dto.setContactInfo(entity.getContactInfo());
        dto.setDoctors(entity.getDoctors().stream().map(doctorConverter::toDto).collect(Collectors.toList()));
        dto.setTreatments(entity.getTreatments().stream().map(treatmentServiceConverter::toDto).collect(Collectors.toList()));
        return dto;
    }

    public ClinicEntity toEntity(ClinicDto dto) {
        ClinicEntity entity = new ClinicEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(addressConverter.toEntity(dto.getAddress()));
        entity.setContactInfo(dto.getContactInfo());
        entity.setDoctors(dto.getDoctors().stream().map(doctorConverter::toEntity).collect(Collectors.toList()));
        entity.setTreatments(dto.getTreatments().stream().map(treatmentServiceConverter::toEntity).collect(Collectors.toList()));
        return entity;
    }
}

package com.asklepios.asklepios_server.doctor.converter;

import com.asklepios.asklepios_server.clinic.converter.ClinicConverter;
import com.asklepios.asklepios_server.doctor.data.dto.DoctorDto;
import com.asklepios.asklepios_server.doctor.data.entity.DoctorEntity;
import com.asklepios.asklepios_server.util.converter.AddressConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DoctorConverter {

    private final EducationConverter educationConverter;

    private final CareerConverter careerConverter;

    private final AddressConverter addressConverter;

    private final ClinicConverter clinicConverter;

    @Autowired
    public DoctorConverter(EducationConverter educationConverter, CareerConverter careerConverter, AddressConverter addressConverter,
                           ClinicConverter clinicConverter) {
        this.educationConverter = educationConverter;
        this.careerConverter = careerConverter;
        this.addressConverter = addressConverter;
        this.clinicConverter = clinicConverter;
    }

    public DoctorDto toDto(DoctorEntity entity) {
        DoctorDto dto = new DoctorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSpecialization(entity.getSpecialization());
        dto.setNationality(entity.getNationality());
        dto.setLanguages(entity.getLanguages());
        dto.setEducationList(entity.getEducationList().stream().map(educationConverter::toDto).collect(Collectors.toList()));
        dto.setCareerList(entity.getCareerList().stream().map(careerConverter::toDto).collect(Collectors.toList()));
        dto.setAchievements(entity.getAchievements());
        dto.setContactInfo(entity.getContactInfo());
        dto.setAcademicRank(entity.getAcademicRank());
        dto.setAddress(addressConverter.toDto(entity.getAddress()));
        dto.setClinic(clinicConverter.toDto(entity.getClinic()));
        return dto;
    }

    public DoctorEntity toEntity(DoctorDto dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSpecialization(dto.getSpecialization());
        entity.setNationality(dto.getNationality());
        entity.setLanguages(dto.getLanguages());
        entity.setEducationList(dto.getEducationList().stream().map(educationConverter::toEntity).collect(Collectors.toList()));
        entity.setCareerList(dto.getCareerList().stream().map(careerConverter::toEntity).collect(Collectors.toList()));
        entity.setAchievements(dto.getAchievements());
        entity.setContactInfo(dto.getContactInfo());
        entity.setAcademicRank(dto.getAcademicRank());
        entity.setAddress(addressConverter.toEntity(dto.getAddress()));
        entity.setClinic(clinicConverter.toEntity(dto.getClinic()));
        return entity;
    }

}

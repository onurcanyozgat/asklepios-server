package com.asklepios.asklepios_server.doctor.converter;

import com.asklepios.asklepios_server.clinic.converter.ClinicConverter;
import com.asklepios.asklepios_server.doctor.data.dto.DoctorDto;
import com.asklepios.asklepios_server.doctor.data.entity.DoctorEntity;
import com.asklepios.asklepios_server.util.converter.AddressConverter;

import java.util.stream.Collectors;

public class DoctorConverter {

    public static DoctorDto toDto(DoctorEntity entity) {
        DoctorDto dto = new DoctorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSpecialization(entity.getSpecialization());
        dto.setNationality(entity.getNationality());
        dto.setLanguages(entity.getLanguages());
        dto.setEducationList(entity.getEducationList().stream().map(EducationConverter::toDto).collect(Collectors.toList()));
        dto.setCareerList(entity.getCareerList().stream().map(CareerConverter::toDto).collect(Collectors.toList()));
        dto.setAchievements(entity.getAchievements());
        dto.setContactInfo(entity.getContactInfo());
        dto.setAcademicRank(entity.getAcademicRank());
        dto.setAddress(AddressConverter.toDto(entity.getAddress()));
        dto.setClinic(ClinicConverter.toDto(entity.getClinic()));
        return dto;
    }

    public static DoctorEntity toEntity(DoctorDto dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSpecialization(dto.getSpecialization());
        entity.setNationality(dto.getNationality());
        entity.setLanguages(dto.getLanguages());
        entity.setEducationList(dto.getEducationList().stream().map(EducationConverter::toEntity).collect(Collectors.toSet()));
        entity.setCareerList(dto.getCareerList().stream().map(CareerConverter::toEntity).collect(Collectors.toSet()));
        entity.setAchievements(dto.getAchievements());
        entity.setContactInfo(dto.getContactInfo());
        entity.setAcademicRank(dto.getAcademicRank());
        entity.setAddress(AddressConverter.toEntity(dto.getAddress()));
        entity.setClinic(ClinicConverter.toEntity(dto.getClinic()));
        return entity;
    }

}

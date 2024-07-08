package com.asklepios.asklepios_server.doctor.data.dto;

import com.asklepios.asklepios_server.clinic.data.dto.ClinicDto;
import com.asklepios.asklepios_server.doctor.data.EnumAcademicRank;
import com.asklepios.asklepios_server.doctor.data.EnumLanguage;
import com.asklepios.asklepios_server.user.EnumNationality;
import com.asklepios.asklepios_server.util.data.dto.AddressDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DoctorDto {
    private long id;

    private String name;

    private String specialization;

    private int experience;

    private EnumNationality nationality;

    private List<EnumLanguage> languages;

    private List<EducationDto> educationList;

    private List<CareerDto> careerList;

    private List<String> achievements;

    private String contactInfo;

    private EnumAcademicRank academicRank;

    private AddressDto address;

    private ClinicDto clinic;

}

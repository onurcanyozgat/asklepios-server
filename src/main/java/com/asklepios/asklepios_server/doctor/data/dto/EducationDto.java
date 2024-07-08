package com.asklepios.asklepios_server.doctor.data.dto;

import com.asklepios.asklepios_server.doctor.data.EnumUniversityDegree;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EducationDto {
    private long id;

    private int startYear;

    private int graduateYear;

    @Enumerated(EnumType.STRING)
    private EnumUniversityDegree degree;

    private String department;

    private String university;

    private String country;
}

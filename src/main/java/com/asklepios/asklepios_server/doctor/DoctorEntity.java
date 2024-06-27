package com.asklepios.asklepios_server.doctor;

import com.asklepios.asklepios_server.clinic.ClinicEntity;
import com.asklepios.asklepios_server.user.EnumNationality;
import com.asklepios.asklepios_server.util.AddressEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "doctor")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String specialization;

    private int experience;

    private EnumNationality nationality;

    private List<EnumLanguage> languages;

    private List<EducationEntity> educationList;

    private List<CareerEntity> careerList;

    private List<String> achievements;

    private String contactInfo;

    private EnumAcademicRank academicRank;

    private AddressEntity address;

    private ClinicEntity clinic;

}

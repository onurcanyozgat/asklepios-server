package com.asklepios.asklepios_server.doctor;

import com.asklepios.asklepios_server.clinic.ClinicEntity;
import com.asklepios.asklepios_server.user.EnumNationality;
import com.asklepios.asklepios_server.util.AddressEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    @Enumerated(EnumType.STRING)
    private EnumNationality nationality;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<EnumLanguage> languages;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EducationEntity> educationList;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CareerEntity> careerList;

    @ElementCollection
    private List<String> achievements;

    private String contactInfo;

    @Enumerated(EnumType.STRING)
    private EnumAcademicRank academicRank;

    @OneToOne
    @JoinColumn(name = "addressId", referencedColumnName = "id")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private ClinicEntity clinic;

}

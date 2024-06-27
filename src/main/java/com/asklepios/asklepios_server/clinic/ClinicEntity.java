package com.asklepios.asklepios_server.clinic;

import com.asklepios.asklepios_server.doctor.DoctorEntity;
import com.asklepios.asklepios_server.util.AddressEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "clinic")
public class ClinicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private AddressEntity address;

    private String contactInfo;

    private List<DoctorEntity> doctors;

}

package com.asklepios.asklepios_server.treatmentservice.data.entity;

import com.asklepios.asklepios_server.clinic.data.entity.ClinicEntity;
import com.asklepios.asklepios_server.treatmentservice.data.EnumTreatment;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "treatmentService")
public class TreatmentServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private EnumTreatment treatment;

    private String description;

    private double price;

    private int durationInMinutes;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private ClinicEntity clinic;

}

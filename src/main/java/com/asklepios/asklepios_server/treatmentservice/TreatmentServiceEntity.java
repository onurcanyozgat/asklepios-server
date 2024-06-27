package com.asklepios.asklepios_server.treatmentservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "treatmentService")
public class TreatmentServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private EnumTreatment treatment;

    private String description;

    private double price;

    private int durationInMinutes;


}

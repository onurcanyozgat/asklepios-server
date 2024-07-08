package com.asklepios.asklepios_server.treatmentservice.data.entity;

import com.asklepios.asklepios_server.treatmentservice.data.EnumTreatment;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TreatmentServiceDto {

    private long id;

    private EnumTreatment treatment;

    private String description;

    private double price;

    private int durationInMinutes;

}

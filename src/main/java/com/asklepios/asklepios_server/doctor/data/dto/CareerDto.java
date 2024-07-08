package com.asklepios.asklepios_server.doctor.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CareerDto {
    private long id;

    private int startYear;

    private int endYear;

    private String title;

    private String name;

    private String description;

    private String country;
}

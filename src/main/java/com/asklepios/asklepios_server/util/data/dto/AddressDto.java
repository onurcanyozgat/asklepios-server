package com.asklepios.asklepios_server.util.data.dto;

import lombok.Data;

@Data
public class AddressDto {

    private Long id;

    private String address;

    private String city;

    private String country;

    double latitude;

    double longitude;

}

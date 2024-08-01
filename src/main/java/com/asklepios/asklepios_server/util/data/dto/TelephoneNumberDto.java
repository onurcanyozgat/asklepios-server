package com.asklepios.asklepios_server.util.data.dto;

import lombok.Data;

@Data
public class TelephoneNumberDto {
    private Long id;

    private String countryCode;

    private String number;

}

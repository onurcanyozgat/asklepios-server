package com.asklepios.asklepios_server.clinic.data.dto;

import com.asklepios.asklepios_server.doctor.data.dto.DoctorDto;
import com.asklepios.asklepios_server.treatmentservice.data.dto.TreatmentServiceDto;
import com.asklepios.asklepios_server.util.data.dto.AddressDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClinicDto {

    private long id;

    private String name;

    private AddressDto address;

    private String contactInfo;

    private List<DoctorDto> doctors;

    private List<TreatmentServiceDto> treatments;

}

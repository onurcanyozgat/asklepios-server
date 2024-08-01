package com.asklepios.asklepios_server.contact.data.dto;

import com.asklepios.asklepios_server.contact.EnumContactFormCommunicationType;
import com.asklepios.asklepios_server.contact.EnumContactFormPatient;
import com.asklepios.asklepios_server.contact.EnumContactFormTime;
import com.asklepios.asklepios_server.treatmentservice.data.EnumTreatment;
import com.asklepios.asklepios_server.util.data.dto.TelephoneNumberDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ContactFormDto {
    private Long id;

    private EnumTreatment treatment;

    private EnumContactFormPatient patient;

    private EnumContactFormTime time;

    private EnumContactFormCommunicationType communicationType;

    private String firstname;

    private String lastname;

    private String email;

    private String note;

    private TelephoneNumberDto telephoneNumber;

    private List<String> imagePaths;
}

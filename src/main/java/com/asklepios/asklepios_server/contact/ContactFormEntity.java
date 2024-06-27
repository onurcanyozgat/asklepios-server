package com.asklepios.asklepios_server.contact;

import com.asklepios.asklepios_server.treatmentservice.EnumTreatment;
import com.asklepios.asklepios_server.util.TelephoneNumberEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contactForm")
public class ContactFormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private EnumTreatment treatment;

    private EnumContactFormPatient patient;

    private EnumContactFormTime time;

    private EnumContactFormCommunicationType communicationType;

    private String firstname;

    private String lastname;

    private String email;

    private TelephoneNumberEntity telephoneNumber;

}

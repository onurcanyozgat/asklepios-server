package com.asklepios.asklepios_server.contact;

import com.asklepios.asklepios_server.treatmentservice.EnumTreatment;
import com.asklepios.asklepios_server.util.TelephoneNumberEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contactForm")
public class ContactFormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private EnumTreatment treatment;

    @Enumerated(EnumType.STRING)
    private EnumContactFormPatient patient;

    @Enumerated(EnumType.STRING)
    private EnumContactFormTime time;

    @Enumerated(EnumType.STRING)
    private EnumContactFormCommunicationType communicationType;

    private String firstname;

    private String lastname;

    private String email;

    @OneToOne
    @JoinColumn(name = "telephoneNumberId", referencedColumnName = "id")
    private TelephoneNumberEntity telephoneNumber;

}

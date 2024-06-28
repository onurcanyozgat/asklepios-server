package com.asklepios.asklepios_server.contact;

import com.asklepios.asklepios_server.user.EnumNationality;
import com.asklepios.asklepios_server.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "contactMessage")
public class ContactMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String subject;

    private String name;

    private String surname;

    @Enumerated(EnumType.STRING)
    private EnumNationality nationality;

    private String message;

    private User receiver;

    private Date messageTime;
}

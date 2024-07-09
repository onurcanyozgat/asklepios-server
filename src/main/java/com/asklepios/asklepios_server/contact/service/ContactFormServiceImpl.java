package com.asklepios.asklepios_server.contact.service;

import com.asklepios.asklepios_server.contact.converter.ContactFormConverter;
import com.asklepios.asklepios_server.contact.data.dto.ContactFormDto;
import com.asklepios.asklepios_server.contact.data.entity.ContactFormEntity;
import com.asklepios.asklepios_server.contact.repository.ContactFormRepository;
import com.asklepios.asklepios_server.mail.converter.MailMessageConverter;
import com.asklepios.asklepios_server.mail.data.MailMessageDto;
import com.asklepios.asklepios_server.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactFormServiceImpl implements ContactFormService {
    private final ContactFormRepository repository;

    private final MailService mailService;

    private final MailMessageConverter mailMessageConverter;

    @Autowired
    public ContactFormServiceImpl(ContactFormRepository repository, MailService mailService, MailMessageConverter mailMessageConverter) {
        this.repository = repository;
        this.mailService = mailService;
        this.mailMessageConverter = mailMessageConverter;
    }

    @Override
    public ContactFormDto save(ContactFormDto contactFormDto) {
        ContactFormEntity contactFormEntity = ContactFormConverter.toEntity(contactFormDto);
        ContactFormEntity savedEntity = repository.save(contactFormEntity);
        sendMail(contactFormDto);
        return ContactFormConverter.toDto(savedEntity);
    }

    private void sendMail(ContactFormDto contactFormDto) {
        MailMessageDto mailMessageDto = mailMessageConverter.toMailMessage(contactFormDto);
        mailService.send(mailMessageDto);
    }
}

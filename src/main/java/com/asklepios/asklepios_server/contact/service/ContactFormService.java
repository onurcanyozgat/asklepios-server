package com.asklepios.asklepios_server.contact.service;

import com.asklepios.asklepios_server.contact.data.dto.ContactFormDto;

public interface ContactFormService {
    ContactFormDto save(ContactFormDto contactFormDto);
}

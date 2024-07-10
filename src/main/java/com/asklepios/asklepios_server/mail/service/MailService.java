package com.asklepios.asklepios_server.mail.service;

import com.asklepios.asklepios_server.mail.data.MailMessageDto;
import jakarta.mail.MessagingException;

public interface MailService {
    void send(MailMessageDto mailMessageDto) throws MessagingException;
}

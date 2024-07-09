package com.asklepios.asklepios_server.mail.service;

import com.asklepios.asklepios_server.mail.data.MailMessageDto;

public interface MailService {
    void send(MailMessageDto mailMessageDto);
}

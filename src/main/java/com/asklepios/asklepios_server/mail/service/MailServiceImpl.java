package com.asklepios.asklepios_server.mail.service;

import com.asklepios.asklepios_server.mail.data.MailMessageDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(MailMessageDto mailMessageDto) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(mailMessageDto.getSender());
        helper.setTo(mailMessageDto.getReceiver());
        helper.setSubject(mailMessageDto.getSubject());
        helper.setText(mailMessageDto.getContent(), true);
        mailSender.send(message);
    }
}

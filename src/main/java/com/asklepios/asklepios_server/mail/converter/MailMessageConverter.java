package com.asklepios.asklepios_server.mail.converter;

import com.asklepios.asklepios_server.contact.data.dto.ContactFormDto;
import com.asklepios.asklepios_server.mail.data.MailMessageDto;
import org.springframework.stereotype.Component;

@Component
public class MailMessageConverter {
    private static final String CONTACT_FORM_SUBJECT = "Information Request!";

    public MailMessageDto toMailMessage(ContactFormDto contactForm) {
        MailMessageDto mailMessageDto = new MailMessageDto();
        mailMessageDto.setId(System.currentTimeMillis());
        mailMessageDto.setSubject(CONTACT_FORM_SUBJECT);
        mailMessageDto.setSender(contactForm.getEmail());
        mailMessageDto.setReceiver("");
        mailMessageDto.setContent(generateMailContent(contactForm));
        return mailMessageDto;
    }

    private String generateMailContent(ContactFormDto contactForm) {
        StringBuilder stringBuilder = new StringBuilder(contactForm.getFirstname()).append(contactForm.getLastname())
                .append("wants to get information. Please respond as soon as possible.")
                .append("Treatment:").append(contactForm.getTreatment())
                .append("Who:").append(contactForm.getPatient())
                .append("Time:").append(contactForm.getTime())
                .append("Communication type:").append(contactForm.getCommunicationType())
                .append("Email:").append(contactForm.getEmail())
                .append("Telephone Number:").append(contactForm.getTelephoneNumber().getCountryCode()).append(contactForm.getTelephoneNumber().getNumber());
        return stringBuilder.toString();
    }

}

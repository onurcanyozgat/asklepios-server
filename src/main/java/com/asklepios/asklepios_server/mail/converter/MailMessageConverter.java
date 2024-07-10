package com.asklepios.asklepios_server.mail.converter;

import com.asklepios.asklepios_server.contact.data.dto.ContactFormDto;
import com.asklepios.asklepios_server.mail.data.MailMessageDto;
import org.springframework.stereotype.Component;

@Component
public class MailMessageConverter {
    private static final String CONTACT_FORM_SUBJECT = "Information Request!";

    private static final String CONTACT_FORM_SENDER = "test@apollotravel.com.tr";

    // TODO: must be sent to operator (info@asklepios.com)
    private static final String CONTACT_FORM_RECEIVER = "onurcanyozgat@hotmail.com";

    public MailMessageDto toMailMessage(ContactFormDto contactForm) {
        MailMessageDto mailMessageDto = new MailMessageDto();
        mailMessageDto.setId(System.currentTimeMillis());
        mailMessageDto.setSubject(CONTACT_FORM_SUBJECT);
        mailMessageDto.setSender(CONTACT_FORM_SENDER);
        mailMessageDto.setReceiver(CONTACT_FORM_RECEIVER);
        mailMessageDto.setContent(generateMailContent(contactForm));
        return mailMessageDto;
    }

    private String generateMailContent(ContactFormDto contactForm) {
        StringBuilder stringBuilder = new StringBuilder("<p>Hello,<p>")
                .append("<p>").append(contactForm.getFirstname()).append(" ").append(contactForm.getLastname())
                .append(" wants to get information about our services. Please respond as soon as possible.</p>")
                .append("<p>Treatment: ").append(contactForm.getTreatment()).append("</p>")
                .append("<p>Who: ").append(contactForm.getPatient()).append("</p>")
                .append("<p>Time: ").append(contactForm.getTime()).append("</p>")
                .append("<p>Communication type: ").append(contactForm.getCommunicationType()).append("</p>")
                .append("<p>Email: ").append(contactForm.getEmail()).append("</p>")
                .append("<p>Telephone Number: ").append(contactForm.getTelephoneNumber().getCountryCode()).append(" ").append(contactForm.getTelephoneNumber().getNumber()).append("</p>");
        return stringBuilder.toString();
    }

}

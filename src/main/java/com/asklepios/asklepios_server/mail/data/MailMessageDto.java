package com.asklepios.asklepios_server.mail.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MailMessageDto {

    private long id;

    private String sender;

    private String receiver;

    private List<String> ccList;

    private String subject;

    private String content;

}

package com.example.common.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public interface MailService {

    @Async
    void sendSimpleMessage(String to, String subject,
                           String text);

    @Async
    void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
}

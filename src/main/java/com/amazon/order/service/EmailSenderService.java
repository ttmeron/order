package com.amazon.order.service;

import javax.mail.MessagingException;

public interface EmailSenderService {
    public void sendSimpleEmail(String email, String body, String subject);
    public void sendEmailWithAttachment(String toEmail,String body, String subject,String attachment) throws MessagingException;
}

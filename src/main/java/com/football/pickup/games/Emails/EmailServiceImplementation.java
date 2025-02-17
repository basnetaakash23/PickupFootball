package com.football.pickup.games.Emails;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImplementation {

    private final JavaMailSender javaMailSender;

    @Async("customAsyncExecutor")
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        System.out.println("Email sent to " + to + " by thread: " + Thread.currentThread().getName());
    }


}

package com.Ustora.book.utils;

import com.Ustora.book.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mail {

    @Autowired
    public JavaMailSender emailSender;

    public void sendMessage() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo();
        message.setSubject("Délai dépassé" );
        message.setText( "Bonjour, vous recevez cet email car votre prêt a dépassé la date limite de restitution. Nous vous prions de bien vouloir vous rendre à votre bibliothèque Ustora. Cordialement" );
        emailSender.send( message );
    }
}

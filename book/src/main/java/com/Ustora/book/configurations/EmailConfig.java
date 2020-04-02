package com.Ustora.book.configurations;

import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {

  /**  @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost( "smtp.gmail.com" );
        mailSender.setPort( 465 );

        mailSender.setUsername( "bibliotheque.employe" );
        mailSender.setPassword( "1234" );

        Properties props = mailSender.getJavaMailProperties();
        props.put( "mail.transport.protocol", "smtp" );
        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.debug", "true" );

        return mailSender;
    }*/
}

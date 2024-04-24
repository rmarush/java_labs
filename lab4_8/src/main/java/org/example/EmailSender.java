package org.example;


import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.*;

public class EmailSender {
    public static void sendEmail(String error) {
        String to = "tobyferrero@gmail.com";

        String from = "rmarushkevych@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rmarushkevych@gmail.com", "rupe jmsb bisf kjqd");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Critical error");

            message.setText(error);

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
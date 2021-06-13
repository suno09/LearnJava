package dz.sundev.service;

import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

    @Override
    public Object sendMail(String to) {

        // Set required configs
        String from = "bibina6666@gmail.com";
        String host = "smtp.gmail.com";
        String port = "587";
        String user = "bibina6666@gmail.com";
        String password = "sabynina";

        // Set system properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", port);
        properties.setProperty("mail.smtp.user", user);
        properties.setProperty("mail.smtp.password", password);
        properties.setProperty("mail.smtp.starttls.enable", "true");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set from email address
            message.setFrom(new InternetAddress(from, "SunDev"));
            // Set the recipient email address
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            // Set email subject
            message.setSubject("Mail Subject");
            // Set email body
            message.setContent("<h1>shemsou9@gmail.com</h1>", "text/html");
            // Set configs for sending email
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            // Send email
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("done");
            return "Email Sent! Check Inbox!";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

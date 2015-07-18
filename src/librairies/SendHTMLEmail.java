package librairies;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendHTMLEmail
{
	
	public void sendMail(String email, String content) {
		/***** CHANGE THESE FOUR VARIABLE VALUES TO REFLECT YOUR ENVIRONMENT ******/
        String user = "icimapoubelle@gmail.com";   // Newly created user on JAMES Server
        String password = "icimapoubelle2"; // user password

        String fromAddress = "schooldoodesgi@gmail.com";
        String toAddress = email;


        // Create a mail session
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "example.com");
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.username", user);
        properties.put("mail.smtp.password", password);
        Session session = Session.getDefaultInstance(properties, null);

        try 
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));

            message.setSubject("Invitation à un SchoolDood");
            message.setText(content);
            Transport.send(message);

            System.out.println("Email sent successfully");
        }
        catch (MessagingException e) 
        {
            e.printStackTrace();
        }
	}

}

package com;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  

public class SendMail {
	
	
	
	public String mail() {  
		 try
		 {
		 Properties prop = System.getProperties();    
		 prop.put("mail.smtp.host", "smtp.gmail.com");
         prop.put("mail.smtp.auth", "true");
         prop.put("mail.smtp.port", "465");
         prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         prop.put("mail.smtp.socketFactory.port", "465");
         prop.put("mail.smtp.socketFactory.fallback", "false");
         prop.setProperty("mail.smtp.class", "com.sun.mail.smtp.SMTPTransport");
     
         Session mailSession=Session.getDefaultInstance(prop, null);
         mailSession.setDebug(true);
         
         Message mailMessage=new MimeMessage(mailSession);
         mailMessage.setFrom(new InternetAddress("sangeethasridharan93@gmail.com"));
         mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("sangeetha.sridharan@conversionsupport.com"));
         mailMessage.setContent("test","text/html");
         mailMessage.setSubject("test");
         
         Transport transport=mailSession.getTransport("smtps");
         transport.connect("smtp.gmail.com","sangeetha sridharan","sangissk@yahoo.in");
         transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
     } catch (Exception e) {
     }

         return "done";
            
   }  

}

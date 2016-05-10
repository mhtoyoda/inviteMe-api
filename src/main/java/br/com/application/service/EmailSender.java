package br.com.application.service;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	private Logger logger = Logger.getLogger(EmailSender.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String to, String subject, String message) throws javax.mail.MessagingException{
		MimeMessage mail = mailSender.createMimeMessage();
		try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);            
            helper.setTo(to);
            helper.setReplyTo(to);
            helper.setFrom("administrator@invvite.me");
            helper.setSubject(subject);
            helper.setText(message);
            mailSender.send(mail);
        } catch (MessagingException e) {
            logger.error("Message not sent "+e.getMessage());
        }
	}
}
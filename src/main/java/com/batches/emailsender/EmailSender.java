package com.batches.emailsender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.Data;


@Data
@Service
public class EmailSender {
	
	@Autowired
	private  JavaMailSender javaMailSender;
	
	//static Logger log = LoggerFactory.getLogger(SignUpService.class);
	
	//public  void sendEmail(String email,String tempPassword,String role) {
	public  void sendEmail(String email) {
		SimpleMailMessage msg = new SimpleMailMessage();
		
		String html = "Temporary Password--"
				+ "\nClick Here To Update http://localhost:9090/updateController/updateurl";
		// messageBodyPart.setText(html, "UTF-8", "html");
		try {
			msg.setTo(email);
			// msg.setFrom("wasim.haider91@gmail.com");
			msg.setSubject("Testing from Spring Boot");
			msg.setText(html);

			javaMailSender.send(msg);
		} catch (MailException e) {
			//log.info("exception in sending mail" + e.getMessage());
		}
	}
}

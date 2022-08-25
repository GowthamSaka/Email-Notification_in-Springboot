package com.org.afrilife.emails.notification.serviceImpl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.org.afrilife.emails.notification.model.MailDetails;
import com.org.afrilife.emails.notification.service.MailDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailDetailsServiceImpl implements MailDetailsService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public ResponseEntity<Map<String, String>> sendEmailNotification(MailDetails mailDetails) {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(mailDetails.getMailSubject());
			mimeMessageHelper.setFrom(new InternetAddress(mailDetails.getMailFrom()));
			mimeMessageHelper.setTo(mailDetails.getMailTo());
			mimeMessageHelper.setText(mailDetails.getMailContent());
			FileSystemResource file = new FileSystemResource(new File(mailDetails.getAttachments()));
	        mimeMessageHelper.addAttachment(file.getFilename(), file);
			javaMailSender.send(mimeMessageHelper.getMimeMessage());
			Map<String, String> result = new HashMap<String, String>();
			result.put("OK", "Successfully Sent Mail");
			return new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
					
		} catch (MessagingException e) {
			e.getMessage();
			Map<String, String> result = new HashMap<String, String>();
			result.put("error", "Something wrong with fields");
			return new ResponseEntity<Map<String, String>>(result, HttpStatus.NOT_FOUND);
		}
	}

}

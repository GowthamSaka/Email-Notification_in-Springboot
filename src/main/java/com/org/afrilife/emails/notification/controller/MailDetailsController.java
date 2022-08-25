package com.org.afrilife.emails.notification.controller;

import java.util.Map;

import com.org.afrilife.emails.notification.model.MailDetails;
import com.org.afrilife.emails.notification.service.MailDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailDetailsController {
	
	@Autowired
	private MailDetailsService mailDetailsService;
	
	@PostMapping("/sendmails")
	public ResponseEntity<Map<String,String>> sendEmails(@RequestBody MailDetails mailDetails) {
		return mailDetailsService.sendEmailNotification(mailDetails);
	}

}

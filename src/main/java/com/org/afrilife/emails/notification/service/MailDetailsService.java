package com.org.afrilife.emails.notification.service;

import java.util.Map;

import com.org.afrilife.emails.notification.model.MailDetails;

import org.springframework.http.ResponseEntity;

public interface MailDetailsService {
	
	public ResponseEntity<Map<String, String>> sendEmailNotification(MailDetails mailDetails);

}

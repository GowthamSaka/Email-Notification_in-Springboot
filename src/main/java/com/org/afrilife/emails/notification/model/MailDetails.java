package com.org.afrilife.emails.notification.model;


import lombok.Data;


@Data
public class MailDetails {
	
	private String mailFrom;
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
//    private String contentType = "text/plain";
    private String attachments;   

}

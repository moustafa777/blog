package com.mum.ea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SchedulingReport {
	@Autowired
	private MailSender mailSender;
	
	@Scheduled(cron="0 0 12 ? * FRI")
	public void reportNumOfArticlesPosted() {
		System.out.println("Scheduling is running");
		
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom("admin@gmail.com");
		smm.setTo("blogOwner@gmail.com");
		smm.setSubject("Blog Report");
		smm.setText("Test scheduling task report");
		
		mailSender.send(smm);
	}

}

package com.example.demo.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.data.Message;
import com.example.demo.data.MessageRepository;

@Service
public class CleaningService {
	
	private MessageRepository messageRepository;
	
	public CleaningService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Scheduled(fixedRate = 1000)
	public void run() {
		LocalTime expiry =  LocalTime.now().minus(5, ChronoUnit.MINUTES);
		Timestamp timestamp = Timestamp.valueOf(expiry.atDate(LocalDate.now()));
		
		List<Message> toDelete = messageRepository.findMessageByCreatedAtBefore(timestamp);
		for (Message message : toDelete) {
			messageRepository.delete(message);
		}
		
	}

}

package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.data.MessageRepository;

@SpringBootTest
public class CleaningServiceTests {

	@Autowired
	MessageRepository repo;
	
	
	@Test
	void testCleaningService() {
		LocalTime expiry =  LocalTime.now().minus(5, ChronoUnit.MINUTES);
		Timestamp timestamp = Timestamp.valueOf(expiry.atDate(LocalDate.now()));
		
		assertNull(repo.findMessageByCreatedAtBefore(timestamp));
	}
	
	
}

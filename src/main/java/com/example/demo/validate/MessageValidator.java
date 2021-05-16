package com.example.demo.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.data.Message;


public class MessageValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Message.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Message message = (Message) target;
		if (checkInputString(message.getEmail())) {
			errors.rejectValue("email", "email.empty");
		}
		
		if (checkInputString(message.getContent())) {
			errors.rejectValue("content", "content.empty");
		}
		
		if (checkInputString(message.getTitle())) {
			errors.rejectValue("title", "title.empty");
		}
		
		if (checkInputInt(message.getMagicNumber())) {
			errors.rejectValue("magicNumber", "magic number equals 0");
		}
		
	}
	
    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
    
    private boolean checkInputInt(int input) {
    	return (input == 0);
    }

}

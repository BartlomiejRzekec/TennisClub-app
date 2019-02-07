package com.example.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.example.entities.Client;
import com.example.utilities.AppTennisClubUtilities;

public class UserRegisterValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Client.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Client client = (Client) target;
		
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.userName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");
		
		if(!client.getEmail().equals(null)) {
			
			boolean isMatch = AppTennisClubUtilities.checkEmailOrPassword(TennisClubConstants.EMAIL_PATTERN, client.getEmail());
			if(!isMatch) {
				errors.rejectValue("email", "error.userEmailIsNotMatch");
			}
		}
		
		if(!client.getPassword().equals(null)) {
			
			boolean isMatch = AppTennisClubUtilities.checkEmailOrPassword(TennisClubConstants.PASSWORD_PATTERN, client.getPassword());
			if(!isMatch) {
				errors.rejectValue("password", "error.userPasswordIsNotMatch");
			}
		}
		
	}
	
	public void validateEmailExist(Client client, Errors errors) {
		if(client != null) {
			errors.rejectValue("email", "error.userEmailExist");
		}
	}

	
}

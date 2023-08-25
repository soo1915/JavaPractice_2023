package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.Join;

public class JoinValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Join.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Join join = (Join) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userid", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userpw1", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userpw2", "required");
		
	}

}

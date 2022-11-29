package com.example.SpringDemo.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDemo.business.abstracts.UserService;
import com.example.SpringDemo.core.entities.User;
import com.example.SpringDemo.core.utilities.results.ErrorDataResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	// Weak İnjection
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	// ResponseEntity bizim hata mesajlarımızı düzenler. Ne döneceğini bilmediğimiz için ? koyarız ki
	// Dönen değere göre response karar versin.
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) { // Valid ile aşağıdaki metod çalışır.
		
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////
	// Global hata yakalama işlemi. Genelde 1 kere yazılır sonra öyle kalır..
	
	// Bu sistemde şu tür bir hata olursa bu anotasyonu çalıştır.
	@ExceptionHandler(MethodArgumentNotValidException.class) // Class tipinde hata gelirse çalışır.
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidateionException(MethodArgumentNotValidException exceptions){
		
		// Map yapısı kullanılır.
		Map<String,String> validationErrors = new HashMap<String, String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları..");
		
		return errors;
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////


	
	
	
}

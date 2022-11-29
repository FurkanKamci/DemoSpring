package com.example.SpringDemo.business.abstracts;

import com.example.SpringDemo.core.entities.User;
import com.example.SpringDemo.core.utilities.results.DataResult;
import com.example.SpringDemo.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	
	DataResult<User> findByEmail(String email);
}

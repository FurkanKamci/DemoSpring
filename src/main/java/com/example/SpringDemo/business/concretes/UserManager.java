package com.example.SpringDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringDemo.business.abstracts.UserService;
import com.example.SpringDemo.core.dataAccess.UserDao;
import com.example.SpringDemo.core.entities.User;
import com.example.SpringDemo.core.utilities.results.DataResult;
import com.example.SpringDemo.core.utilities.results.Result;
import com.example.SpringDemo.core.utilities.results.SuccessDataResult;
import com.example.SpringDemo.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{

	//////////////////////////////////////
	// injection
	private UserDao userDao;
	@Autowired  // IoC den userdao instance 'ını getirir ve içerisindeki metodlara erişebiliriz.
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	//////////////////////////////////////

	@Override
	public Result add(User user) {
		
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi");
	}
	
	@Override
	public DataResult<User> findByEmail(String email) {
		
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu!");
	}
	//////////////////////////////////////


}

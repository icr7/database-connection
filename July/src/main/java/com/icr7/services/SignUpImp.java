package com.icr7.services;

import com.icr7.UsersDao.CrudDao;
import com.icr7.entity.UserEntity;

public class SignUpImp {
	public SignUpImp() {
		// no arg constructor
	}

	public String saveRegisteredData(UserEntity uiEntity) {
		CrudDao crudDao = new CrudDao();

		UserEntity userEntity = crudDao.getUserData(uiEntity.getEmail());

		if(uiEntity.getFirstName()==null) {return "first name cannot be empty";}
		if(uiEntity.getLastName()==null) {return "last name cannot be empty";}
		if(uiEntity.getEmail()==null) {return "email cannot be empty";}
		if(uiEntity.getMobileNo()==null) {return "mobile number cannot be empty";}
		if(uiEntity.getPassWord()==null) {return "password cannot be empty";}
		
		if(uiEntity.getFirstName().isBlank()) {return "first name cannot be empty";}
		if(uiEntity.getLastName().isBlank()) {return "last name cannot be empty";}
		if(uiEntity.getEmail().isBlank()) {return "email cannot be empty";}
		if(uiEntity.getMobileNo().isBlank()) {return "mobile number cannot be empty";}
		if(uiEntity.getPassWord().isBlank()) {return "password cannot be empty";}
		
		if (userEntity != null) {
			return "Email Already exist";
		}

		else {
			crudDao.saveUserData(uiEntity);
			return "User Registered Successfully";
		}
	}
}

package com.icr7.services;

import com.icr7.UsersDao.CrudDao;
import com.icr7.entity.UserEntity;
import com.icr7.entity.UserEntityWithMsg;

public class LoginImp {
	public LoginImp() {
		//no args constructor
	}

	public UserEntityWithMsg getLogin(String email, String pass) {
		CrudDao crudDao = new CrudDao();
		UserEntity temp = crudDao.getUserData(email);
		String msg;
		if (temp != null) {
			msg = "user exist";
		} else
			msg = "user not exist";

		if (temp==null) {
			UserEntityWithMsg entityWithMsg = new UserEntityWithMsg(null, msg);
			return entityWithMsg;
		}

		else {
			if (!temp.getPassWord().equals(pass)) {
				msg = "incorrect password";
				UserEntityWithMsg entityWithMsg = new UserEntityWithMsg(null, msg);

				return entityWithMsg;
			}

			else {
				msg = "login successful";
				UserEntityWithMsg entityWithMsg = new UserEntityWithMsg(temp, msg);

				return entityWithMsg;
			}
		}

	}
}

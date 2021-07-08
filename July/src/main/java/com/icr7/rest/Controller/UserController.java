package com.icr7.rest.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icr7.UsersDao.CrudDao;
import com.icr7.entity.UserEntity;
import com.icr7.entity.UserEntityWithMsg;
import com.icr7.services.LoginImp;
import com.icr7.services.SignUpImp;


@RestController
@RequestMapping("/user")@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@GetMapping("/loginPage/{email}/{password}")
	public UserEntityWithMsg getLogin(@PathVariable String email,@PathVariable String password) {
        LoginImp login=new LoginImp();	
		UserEntityWithMsg entityWithMsg=login.getLogin(email, password);
	return entityWithMsg;	
	}
	
	@PostMapping("/SignUpPage")
	public String setSignUp(@RequestBody UserEntity userEntity) {
		System.out.println("inside controller checking incomming data:");
		System.out.println(userEntity.getFirstName());
		System.out.println(userEntity.getLastName());
		System.out.println(userEntity.getMobileNo());
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getPassWord());
		
		
		System.out.println();
		SignUpImp signUpImp=new SignUpImp();
		String status=signUpImp.saveRegisteredData(userEntity);
		return status;
	}
	@GetMapping("/allData")
	public List<UserEntity> abc() {
		CrudDao crudDao=new CrudDao();
		List<UserEntity> allData=crudDao.getUserData();
		return allData;
	}
	
}

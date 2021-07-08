package com.icr7.entity;

public class UserEntityWithMsg {
	UserEntity entity;
	String status;
	
	public UserEntityWithMsg() {
		//no arg constructor
	}

	public UserEntityWithMsg(UserEntity entity, String status) {
		super();
		this.entity = entity;
		this.status = status;
	}

	public UserEntity getEntity() {
		return entity;
	}

	public void setEntity(UserEntity entity) {
		this.entity = entity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
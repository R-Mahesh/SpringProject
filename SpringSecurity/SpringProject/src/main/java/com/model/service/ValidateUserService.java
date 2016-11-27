package com.model.service;

import com.model.entity.User;

public interface ValidateUserService {

	public abstract boolean authenticateUser(User user);
}

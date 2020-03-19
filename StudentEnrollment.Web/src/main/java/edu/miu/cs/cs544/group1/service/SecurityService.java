package edu.miu.cs.cs544.group1.service;

import java.util.List;

import edu.miu.cs.cs544.group1.domain.security.ChangePasswordModel;
import edu.miu.cs.cs544.group1.domain.security.Person;

public interface SecurityService {
	
	public boolean checkLogin(String email, String password);
	public List<Person> getPeople();
	public String changePassword(long id, ChangePasswordModel changePwd);

}

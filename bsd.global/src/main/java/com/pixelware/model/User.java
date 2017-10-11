package com.pixelware.model;

import java.io.Serializable;

public class User implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int code;
private String email;
private String name;
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public User(int code, String email, String name) {
	super();
	this.code = code;
	this.email = email;
	this.name = name;
}
public User(){}
@Override
public String toString() {
	return "User [code=" + code + ", email=" + email + ", name=" + name + "]";
};

}

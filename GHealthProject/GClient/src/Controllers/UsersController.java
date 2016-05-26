package Controllers;

import java.util.List;

import Client.Application;
import Utils.Request;
import models.User;

public class UsersController {
	public static User getUser(String sid){
		Request r = new Request("users/getById");
		r.addParam("sid", sid);
		return (User)Application.client.sendRequest(r);
	}
	
	public static boolean authinticateUser(User u, String password){
		if(u.isLocked())
			return false;
		return u.getPass().equals(password);
	}

	public static boolean setOnline(User u){
		Request r = new Request("users/setOnline");
		r.addParam("user", u);
		return (boolean)Application.client.sendRequest(r);
	}
	
	
	public static List<User> getLockedUsers(){
		Request r = new Request("users/getLockedUsers");
		return (List<User>) Application.client.sendRequest(r);

	}
	
	public static List<User> getOnlineUsers(){
		Request r = new Request("users/getOnlineUsers");
		return (List<User>) Application.client.sendRequest(r);
	}
}

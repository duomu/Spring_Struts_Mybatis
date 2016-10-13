package com.yll.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yll.ssm.base.BaseAction;
import com.yll.ssm.model.User;
import com.yll.ssm.service.UserService;

@Controller
public class UserAction extends BaseAction {
	private static Logger logger = Logger.getLogger(UserAction.class); 
	@Autowired
	private UserService userService;

	private Integer userId;
	private String userName;
	private String password;
	private String email;
	private short sex;
	private Integer age;
	private String address;
	private String image;
	
	public String showUser(){
		return SUCCESS;
	}
	/**
	 * 添加用户
	 * @return
	 */
	public String addUser(){
		PrintWriter out=null;
		try {
			out =response.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}  
		try {
			User user=new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setEmail(email);
			user.setSex(sex);
			user.setAge(age);
			user.setAddress(address);
			user.setImage(image);
			if(userService.getUserByName(userName)==null){
				userService.insertUser(user);
				out.write("0");//插入成功
			}else{
				logger.error("Error in addUser: 该用户名已被使用，请重新输入！");
				out.write("1");//已存在用户名
				return ERROR;
			}
			
		} catch (Exception e) {
			logger.error("Exception in addUser: "+e.getMessage());
			out.write("2");//插入异常
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询用户
	 * @return
	 */
	public String queryUser(){		
		try {
			//String userName=request.getParameter("userName");
			User user=userService.getUserByName(userName);
			request.setAttribute("user", user);
		} catch (Exception e) {
			logger.error("Exception in queryUser: "+e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 修改用户
	 * @return
	 */
	public String alterUser(){
		try{
			//Integer userId=Integer.valueOf(request.getParameter("userId"));
			User user=new User();
			user.setUserId(userId);
			user.setUserName(userName);
			user.setPassword(password);
			user.setEmail(email);
			user.setSex(sex);
			user.setAge(age);
			user.setAddress(address);
			user.setImage(image);
			userService.updateUser(user);
		}catch(Exception e){
			logger.error("Exception in alterUser: "+e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String deleteUser(){
		try{
			//Integer userId=Integer.valueOf(request.getParameter("userId"));
			userService.deleteUser(userId);
		}catch(Exception e){
			logger.error("Exception in deleteUser: "+e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public short getSex() {
		return sex;
	}
	public void setSex(short sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}	
}

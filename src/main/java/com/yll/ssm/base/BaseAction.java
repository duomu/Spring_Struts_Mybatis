package com.yll.ssm.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.BeanFactory;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	public HttpServletRequest request;
	public HttpServletResponse response;
	public BeanFactory factory;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		this.factory=BeanHelper.getBeanFactory(request);
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;

	}

}

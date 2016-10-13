package com.yll.ssm.base;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BeanHelper {
	private static BeanFactory beanFactory=null;
	
	public static BeanFactory getBeanFactory(HttpServletRequest request){
		if(beanFactory==null){
			ServletContext servletContext=request.getSession().getServletContext();
			beanFactory=WebApplicationContextUtils.getWebApplicationContext(servletContext);
		}
		return beanFactory;
	}
}

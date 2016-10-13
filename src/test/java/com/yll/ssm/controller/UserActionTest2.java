package com.yll.ssm.controller;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

public class UserActionTest2 extends StrutsSpringTestCase {
	private static Logger logger = Logger.getLogger(UserActionTest2.class); 
	// 重写父类方法,指定配置文件的名字
	protected String[] getContextLocations() {
		return new String[] { "classpath*:struts.xml", "classpath*:testContext.xml" };
	}

	@Test
	public void testShowUser() throws Exception {
		ActionProxy proxy = getActionProxy("/showUser.action");//若namespace为“/”，则此处路径为/showUser.action
		UserAction action =(UserAction)proxy.getAction();
		String res = action.execute();//模拟调用web链接，返回的是action方法的返回数据
		assertEquals("success", res);
		logger.info("result: "+res);
	}
	
	@Test
	public void testAddUser() throws Exception{
		request.addParameter("userName", "lele");//模拟web传入的参数
		request.addParameter("password", "password");
		String result=executeAction("/addUser");//模拟调用web链接，action返回的数据为json格式，result是response的内容
		logger.info("result: "+result);
		
//		request.setParameter("userName", "mm");//模拟web传入的参数
//		request.setParameter("password", "password");
//		ActionProxy proxy=getActionProxy("/addUser.action");//action代理
//		UserAction userAction=(UserAction)proxy.getAction();//实例化action
//		assertNotNull(userAction);
//		String result=proxy.execute();//适合无参调用，有参报错：java.lang.IllegalStateException: Context attribute is not of type WebApplicationContext:
//		assertEquals("success", result);
	}

	@Test
	public void testQueryUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlterUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

}

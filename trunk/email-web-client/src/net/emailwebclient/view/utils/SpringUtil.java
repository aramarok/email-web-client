package net.emailwebclient.view.utils;

import net.emailwebclient.bl.Services;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext ctx;

	public static Services getServices() {
		return (Services)ctx.getBean("services");
		// return (Services) JSFUtil.getBean("services");
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringUtil.ctx = applicationContext;
	}

}
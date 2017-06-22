package com.njq.nongfadai.initial;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class UserInitialBean implements InitializingBean,BeanPostProcessor {
	public UserInitialBean(){
		System.out.println("###UserInitialBean 构造函数");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("--UserInitialBean afterPropertiesSet ================");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("--UserInitialBean postProcessBeforeInitialization begin()...");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("--UserInitialBean postProcessAfterInitialization begin()...");
		return bean;
	}

}

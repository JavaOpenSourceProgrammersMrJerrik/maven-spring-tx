package com.njq.nongfadai.beanprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.njq.nongfadai.instance.UserInstance;

public class UserBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("--postProcessBeforeInitialization");
		if(bean instanceof UserInstance){
			UserInstance instance = ((UserInstance) bean);
			instance.setUserName("postProcessBeforeInitialization");
			return instance;
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("--postProcessAfterInitialization");
		if(bean instanceof UserInstance){
			UserInstance instance = ((UserInstance) bean);
			instance.setUserName("postProcessAfterInitialization");
			return instance;
		}
		return bean;
	}
}

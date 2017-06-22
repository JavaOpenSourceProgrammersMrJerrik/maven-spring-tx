package com.njq.nongfadai.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class UserBeanFactoryAware implements BeanFactoryAware, EnvironmentAware {

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("^^^^^^UserBeanFactoryAware setEnvironment begin()  " + environment);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("^^^^^^UserBeanFactoryAware setBeanFactory begin()  " + beanFactory);
	}

}

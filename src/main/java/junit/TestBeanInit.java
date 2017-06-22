package junit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njq.nongfadai.service.ILcAccountFlowService;

public class TestBeanInit {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println(ctx.getBean("user"));
		System.out.println(ctx.getBean("user2"));
		System.out.println(ctx.getBean(ILcAccountFlowService.class));
	}
	/**
	 * output:
+UserBeanFactoryProcessor postProcessBeanFactory process()...  ====>  refresh()->invokeBeanFactoryPostProcessors
###UserInitialBean 构造函数      ====>(该类实现了BeanPostProcessor)  refresh()->registerBeanPostProcessors()->AbstractAutowireCapableBeanFactory.doCreateBean.createBeanInstance()
--UserInitialBean afterPropertiesSet ================      ====>  AbstractAutowireCapableBeanFactory.doCreateBean.initializeBean()
--postProcessBeforeInitialization
--UserInitialBean postProcessBeforeInitialization begin()...
--postProcessAfterInitialization
--UserInitialBean postProcessAfterInitialization begin()...
%%%%UserInstance construct
--postProcessBeforeInitialization
--UserInitialBean postProcessBeforeInitialization begin()...
--postProcessAfterInitialization
--UserInitialBean postProcessAfterInitialization begin()...
%%%%UserInstance construct
--postProcessBeforeInitialization
--UserInitialBean postProcessBeforeInitialization begin()...
--postProcessAfterInitialization
--UserInitialBean postProcessAfterInitialization begin()...
^^^^^^UserBeanFactoryAware setBeanFactory begin()  org.springframework.beans.factory.support.DefaultListableBeanFactory@406a76c6: defining beans [
^^^^^^UserBeanFactoryAware setEnvironment begin()  StandardEnvironment {activeProfiles=[], defaultProfiles=[default], propertySources=
--postProcessBeforeInitialization
--UserInitialBean postProcessBeforeInitialization begin()...
--postProcessAfterInitialization
--UserInitialBean postProcessAfterInitialization begin()...
UserInstance [id=3, userName=postProcessAfterInitialization, age=23]
UserInstance [id=5, userName=postProcessAfterInitialization, age=28]
	 */
}

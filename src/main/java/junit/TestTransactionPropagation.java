package junit;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njq.nongfadai.dao.model.s61.LcAccountFlow;
import com.njq.nongfadai.service.ILcAccountFlowService;

/**
 * 测试事务的传播特性
 * 事务方法 call 事务方法
 * 非事务方法 call this.事务方法
 * 非事务方法 call proxy.事务方法
 * @author Jerrik
 */
public class TestTransactionPropagation {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		final ILcAccountFlowService lcAccountFlowService = ctx.getBean(ILcAccountFlowService.class);

		/**
		 *  非事务方法,this调用事务方法(数据都不回滚)
		 *	218	1	4444	1	2017-06-22 10:01:49	0.00	0.00	0.00	updateLcAccountFlowById	YDZ
		 */
		//lcAccountFlowService.addLcAccountFlowWithNoTransaction(getLcAccountFlow("测试非事务方法,this调用事务方法1"));
		
		/**
		 * 非事务方法,然后代理对象调用事务方法(非事务方法不回滚,事务方法回滚)
		 * 219	1	4444	1	2017-06-22 10:02:29	0.00	0.00	0.00	测试非事务方法,然后代理对象调用事务方法2	YDZ	
		 */
		//lcAccountFlowService.addLcAccountFlowWithNoTransaction(getLcAccountFlow("测试非事务方法,然后代理对象调用事务方法2"), lcAccountFlowService);
		
		
		/**
		 * 事务方法调用事务方法(数据回滚)
		 */
		lcAccountFlowService.addLcAccountFlowWithTransaction(getLcAccountFlow("测试事务方法,this调用事务方法3"));
	}

	private static LcAccountFlow getLcAccountFlow(String desc) {
		LcAccountFlow lcAccountFlow = new LcAccountFlow();
		lcAccountFlow.setAccountId(1);
		lcAccountFlow.setToAccountId(1);
		lcAccountFlow.setBussTypeId(4444);
		lcAccountFlow.setCreateTime(new Date());
		lcAccountFlow.setCheckStatus("YDZ");
		lcAccountFlow.setIncome(BigDecimal.ZERO);
		lcAccountFlow.setExpenses(BigDecimal.ZERO);
		lcAccountFlow.setBalance(BigDecimal.ZERO);
		lcAccountFlow.setDesc(desc);
		return lcAccountFlow;
	}
}

package junit;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njq.nongfadai.dao.interfaces.ILcAccountFlowDao;
import com.njq.nongfadai.dao.model.s61.LcAccountFlow;

public class TestTransaction1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		final ILcAccountFlowDao lcAccountFlowDao = ctx.getBean(ILcAccountFlowDao.class);

		lcAccountFlowDao.addEntity(getLcAccountFlow(LcAccountFlowDaoImplTest.ROLLBACK_ON_STRING_DESC + "1"));//由于没有触发回滚 数据提交成功
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				lcAccountFlowDao.addEntity(getLcAccountFlow("another flow"));//由于addEntity单独在一个事务当中,数据提交成功
				
				System.out.println("新增第二条流水");
				LcAccountFlow lcAccountFlow = lcAccountFlowDao.findEntityById(139);
				lcAccountFlow.setDesc(LcAccountFlowDaoImplTest.ROLLBACK_ON_STRING_DESC);
				lcAccountFlowDao.updateEntity(lcAccountFlow);//方法内抛出异常  数据回滚
			}
		}).start();
		
		
		//注意：这里手动触发异常,并不能触发addEntity回滚,因为addEntity单独在一个事务当中。 要想触发回滚,只能将异常放在addEntity当中
		//throw new RuntimeException("自定义异常");

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

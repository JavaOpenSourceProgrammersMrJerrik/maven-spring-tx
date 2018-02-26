package junit;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.njq.nongfadai.dao.interfaces.ILcAccountFlowDao;
import com.njq.nongfadai.dao.model.s61.LcAccountFlow;

public class TransactionTemplateTester extends AbstractTransactionJunitTest {

	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Autowired
	private ILcAccountFlowDao lcAccountFlowDao;
	
	@Test
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void testTransaction1(){
		lcAccountFlowDao.addEntity(getLcAccountFlow("testTransaction3"));
		transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				lcAccountFlowDao.addEntity(getLcAccountFlow("testTransaction1"));
				lcAccountFlowDao.addEntity(getLcAccountFlow("testTransaction2"));
				throw new RuntimeException("失败");
			}
		});
	}
	
	private LcAccountFlow getLcAccountFlow(String desc) {
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

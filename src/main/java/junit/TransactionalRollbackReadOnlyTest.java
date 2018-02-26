package junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.njq.nongfadai.dao.interfaces.ILcAccountFlowDao;
import com.njq.nongfadai.service.ITxService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class TransactionalRollbackReadOnlyTest {

	@Autowired
	private ITxService txService;

	/**
	 * org.springframework.transaction.UnexpectedRollbackException: Transaction
	 * rolled back because it has been marked as rollback-only
	 */
	@Test
	@Transactional
	public void testRollbackReadOnly() {
		txService.doTransaction();
	}
}

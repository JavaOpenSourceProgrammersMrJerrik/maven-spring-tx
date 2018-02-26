package junit;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.njq.nongfadai.dao.interfaces.ILcAccountFlowDao;
import com.njq.nongfadai.dao.model.s61.LcAccountFlow;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class LcAccountFlowDaoImplTest {

	@Autowired
	private ILcAccountFlowDao lcAccountFlowDao;

	@Autowired
	private PlatformTransactionManager txManager;
	
	@Autowired
	private TransactionTemplate transactionTemplate;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddEntity() {
		lcAccountFlowDao.addEntity(getLcAccountFlow("test add"));
	}

	/**
	 * 主线程和子线程都使用事务 结果: 插入的数据都回滚
	 */
	@Test
	@Transactional
	public void testTransaction1() {
		lcAccountFlowDao.addEntity(getLcAccountFlow("testTransaction1"));
		new Thread(new Runnable() {
			@Override
			public void run() {
				// 编程式获取事务
				DefaultTransactionDefinition def = new DefaultTransactionDefinition();
				def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
				TransactionStatus status = txManager.getTransaction(def); // 获得事务状态
				try {
					System.out.println("new thread()");
					System.out.println("新增第二条流水");
					lcAccountFlowDao.addEntity(getLcAccountFlow("testTransaction1 new thread"));

					int i = 1 / 0;

					txManager.commit(status);
				} catch (Exception e) {
					e.printStackTrace();
					txManager.rollback(status);
				}

			}
		}).start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 抛出异常
		throw new RuntimeException("自定义异常");
	}

	/**
	 * 主线程使用事务,子线程没有事务 
	 * 结果: 主线程数据回滚,子线程数据 插入成功。
	 * 结论:
	 * 	事务范围内 使用新的线程 导致没有事务
	 */
	@Test
	//@Transactional
	public void testTransaction2() {
		lcAccountFlowDao.addEntity(getLcAccountFlow("testTransaction1"));
		new Thread(new Runnable() {
			@Override
			public void run() {//transactionTemplate 有事务
				transactionTemplate.execute(new TransactionCallback<Object>() {
					@Override
					public Object doInTransaction(TransactionStatus status) {
						System.out.println("new thread()");
						System.out.println("新增第二条流水");
						lcAccountFlowDao.addEntity(getLcAccountFlow("testTransaction1 new thread"));
						int i = 1 / 0;//抛出异常
						return null;
					}
				});
			
			}
		}).start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 抛出异常
		throw new RuntimeException("自定义异常");
	}
	
	public static final String ROLLBACK_ON_STRING_DESC = "roll back thread";
	
	/**
	 * 主线程使用事务,子线程调用事务方法updateEntity,在updateEntity中抛出异常,事务成功回滚
	 */
	@Test
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void testTransaction3() {
		lcAccountFlowDao.addEntity(getLcAccountFlow("testTransaction1"));
		new Thread(new Runnable() {
			@Override
			public void run() {
				/**
				 * step 1 事务不回滚
				 */
				System.out.println("new thread3()");
				lcAccountFlowDao.addEntity(getLcAccountFlow("roll back thread1"));
				
				/**
				 * 事务回滚
				 * step 2 updateEntity抛出异常,回滚事务。但是由于step 1和step 2不在一个事务当中,导致step 1 不能回滚
				 */
				LcAccountFlow lcAccountFlow = lcAccountFlowDao.findEntityById(31);
				lcAccountFlow.setDesc(ROLLBACK_ON_STRING_DESC);//根据该DESC判断是否回滚
				lcAccountFlowDao.updateEntity(lcAccountFlow);
			}
		}).start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 抛出异常
		throw new RuntimeException("自定义异常");
	}

	@Test
	public void testDeleteEntityById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEntityById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEntity() {
		fail("Not yet implemented");
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

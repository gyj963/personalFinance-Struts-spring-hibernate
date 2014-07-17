package com.pf.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 13-12-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
@Transactional
public class UserLoginActionTest {
    @Autowired
    UserLoginAction userLoginAction;
    private static final Log log = LogFactory.getLog(UserLoginActionTest.class);
    @Test
    public void testExecute() throws Exception {
        userLoginAction.execute();
    }
}

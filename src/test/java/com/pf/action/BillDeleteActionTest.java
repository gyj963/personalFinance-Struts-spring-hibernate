package com.pf.action;

import com.pf.TestBase;
import com.pf.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 13-12-27.
 */
public class BillDeleteActionTest extends TestBase {
    private static final Log log = LogFactory.getLog(BillDeleteActionTest.class);
    @Autowired
    private BillDeleteAction billDeleteAction;
    @Autowired
    private BillManager billManager;
    @Test
    public void testExecute() throws Exception {
        billManager.deleteBillById(9);
    }
}

package net.plang.DYAccount.common.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.dao.DataAccessException;

public class DataAccessExceptionAdvice implements ThrowsAdvice {
    private Log log = LogFactory.getLog(this.getClass());

    public void afterThrowing(DataAccessException ex) throws Throwable {
        log.fatal(ex.getMessage());
        throw ex;
    }

    public void afterThrowing(Exception ex) throws Throwable {
        log.fatal("에러"+ex.getMessage());
        throw ex;
    }
}

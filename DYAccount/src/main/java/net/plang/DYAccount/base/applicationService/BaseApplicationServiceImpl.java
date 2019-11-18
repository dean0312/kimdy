package net.plang.DYAccount.base.applicationService;

import java.util.ArrayList;

import net.plang.DYAccount.base.exception.IdNotFoundException;
import net.plang.DYAccount.base.exception.PwMissmatchException;
import net.plang.DYAccount.base.to.SlipIreportBean;
import net.plang.DYAccount.hr.dao.EmployeeDAO;
import net.plang.DYAccount.hr.dao.EmployeeDAOImpl;
import net.plang.DYAccount.hr.to.EmployeeBean;

public class BaseApplicationServiceImpl implements BaseApplicationService {
    private EmployeeDAO employeeDAO;

    @Override
    public EmployeeBean getLoginData(String empCode, String userPw) throws IdNotFoundException, PwMissmatchException {
        EmployeeBean employeeBean = employeeDAO.selectEmployee(empCode);

        if (employeeBean == null)
            throw new IdNotFoundException("존재 하지 않는 계정입니다.");
        else {
            if (!employeeBean.getUserPw().equals(userPw))
                throw new PwMissmatchException("비밀번호가 틀립니다.");
        }

        return employeeBean;
    }
    
	@Override
	public ArrayList<SlipIreportBean> getIreportData(String slipNo) {
		// TODO Auto-generated method stub
		System.out.println("리포터 어플리까지옴");
		return null;
	}
	  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
	        this.employeeDAO = employeeDAO;
	    }
}

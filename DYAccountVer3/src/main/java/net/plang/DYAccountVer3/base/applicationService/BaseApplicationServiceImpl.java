package net.plang.DYAccountVer3.base.applicationService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.base.exception.IdNotFoundException;
import net.plang.DYAccountVer3.base.exception.PwMissmatchException;
import net.plang.DYAccountVer3.base.to.SlipIreportBean;
import net.plang.DYAccountVer3.hr.dao.EmployeeDAO;
import net.plang.DYAccountVer3.hr.to.EmployeeBean;

@Component
@Transactional
public class BaseApplicationServiceImpl implements BaseApplicationService {
	@Autowired
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

}

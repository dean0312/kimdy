package net.plang.DYAccountVer3.hr.applicationservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.base.dao.DetailCodeDAO;
import net.plang.DYAccountVer3.base.to.DetailCodeBean;
import net.plang.DYAccountVer3.hr.dao.EmployeeDAO;
import net.plang.DYAccountVer3.hr.to.EmployeeBean;

@Component
@Transactional
public class HrApplicationServiceImpl implements HrApplicationService {
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private DetailCodeDAO codeDetailDAO;

	@Override
	public ArrayList<EmployeeBean> findEmployeeList(String deptCode) {
		return employeeDAO.selectEmployeeList(deptCode);
	}

	@Override
	public EmployeeBean findEmployee(String empCode) {
		return employeeDAO.selectEmployee(empCode);
	}

	@Override
	public void batchEmployeeInfo(EmployeeBean employeeBean) {
		employeeDAO.updateEmployeeInfo(employeeBean);
	}

	@Override
	public void batchEmployee(ArrayList<EmployeeBean> empList) {
		for (EmployeeBean employBean : empList) {
			String empStatus = employBean.getStatus();
			switch (empStatus) {
			case "update":
				modifyEmployee(employBean);
				break;
			case "delete":
				removeEmployee(employBean);
				break;
			}
		}
	}

	private void modifyEmployee(EmployeeBean employeeBean) {
		employeeDAO.updateEmployee(employeeBean);
		String empCode = employeeBean.getEmpCode();
		String empName = employeeBean.getEmpName();
		DetailCodeBean detailCodeBean = new DetailCodeBean();
		detailCodeBean.setDivisionCodeNo("HR-02");
		detailCodeBean.setDetailCode(empCode);
		detailCodeBean.setDetailCodeName(empName);
		codeDetailDAO.updateDetailCode(detailCodeBean);

	}

	public void removeEmployee(EmployeeBean employBean) {
		employeeDAO.deleteEmployee(employBean.getEmpCode());
		codeDetailDAO.deleteDetailCode(employBean.getEmpCode());
	}

	@Override
	public void registerEmployee(EmployeeBean employeeBean) {
		employeeDAO.insertEmployee(employeeBean);
		String empCode = employeeBean.getEmpCode();
		String empName = employeeBean.getEmpName();
		DetailCodeBean detailCodeBean = new DetailCodeBean();
		detailCodeBean.setDivisionCodeNo("HR-02");
		detailCodeBean.setDetailCode(empCode);
		detailCodeBean.setDetailCodeName(empName);
		codeDetailDAO.insertDetailCode(detailCodeBean);
	}
}

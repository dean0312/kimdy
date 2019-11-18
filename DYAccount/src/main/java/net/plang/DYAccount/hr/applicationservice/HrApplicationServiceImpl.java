package net.plang.DYAccount.hr.applicationservice;

import java.util.ArrayList;

import net.plang.DYAccount.base.dao.DetailCodeDAO;
import net.plang.DYAccount.base.to.DetailCodeBean;
import net.plang.DYAccount.hr.dao.EmployeeDAO;
import net.plang.DYAccount.hr.to.EmployeeBean;

public class HrApplicationServiceImpl implements HrApplicationService {
	private EmployeeDAO employeeDAO;
	private DetailCodeDAO codeDetailDAO;
	private static HrApplicationService instance;

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public void setDetailCodeDAO(DetailCodeDAO codeDetailDAO) {
		this.codeDetailDAO = codeDetailDAO;
	}

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

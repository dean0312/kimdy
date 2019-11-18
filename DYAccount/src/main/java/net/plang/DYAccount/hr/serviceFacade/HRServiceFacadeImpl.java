package net.plang.DYAccount.hr.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccount.hr.applicationservice.HrApplicationService;
import net.plang.DYAccount.hr.to.EmployeeBean;

public class HRServiceFacadeImpl implements HRServiceFacade {

	HrApplicationService hrApplicationService;

	public void setHrApplicationService(HrApplicationService hrApplicationService) {
		this.hrApplicationService = hrApplicationService;
	}

	@Override
	public EmployeeBean findEmployee(String empCode) {
		return hrApplicationService.findEmployee(empCode);
	}

	@Override
	public ArrayList<EmployeeBean> findEmployeeList(String deptCode) {
		return hrApplicationService.findEmployeeList(deptCode);
	}

	@Override
	public void batchEmployeeInfo(EmployeeBean employeeBean) {
		hrApplicationService.batchEmployeeInfo(employeeBean);
	}

	@Override
	public void batchEmployee(ArrayList<EmployeeBean> empList) {
		hrApplicationService.batchEmployee(empList);
	}

	@Override
	public void registerEmployee(EmployeeBean employeeBean) {
		hrApplicationService.registerEmployee(employeeBean);
	}

	@Override
	public void removeEmployee(EmployeeBean employeeBean) {
		hrApplicationService.removeEmployee(employeeBean);
	}
}

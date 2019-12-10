package net.plang.DYAccountVer3.hr.serviceFacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.plang.DYAccountVer3.hr.applicationservice.HrApplicationService;
import net.plang.DYAccountVer3.hr.to.EmployeeBean;

@Service
public class HRServiceFacadeImpl implements HRServiceFacade {
	@Autowired
	HrApplicationService hrApplicationService;

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

package net.plang.DYAccountVer3.hr.applicationservice;

import java.util.ArrayList;

import net.plang.DYAccountVer3.hr.to.EmployeeBean;

public interface HrApplicationService {
    public ArrayList<EmployeeBean> findEmployeeList(String deptCode);

    public EmployeeBean findEmployee(String empCode);

    public void batchEmployeeInfo(EmployeeBean employeeBean);

    public void batchEmployee(ArrayList<EmployeeBean> empList);

    public void registerEmployee(EmployeeBean employeeBean);

	public void removeEmployee(EmployeeBean employeeBean);

}

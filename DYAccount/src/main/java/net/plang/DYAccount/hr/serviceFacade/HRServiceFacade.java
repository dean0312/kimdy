package net.plang.DYAccount.hr.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccount.hr.to.EmployeeBean;

public interface HRServiceFacade {

    public ArrayList<EmployeeBean> findEmployeeList(String deptCode);

    public EmployeeBean findEmployee(String empCode);

    public void batchEmployeeInfo(EmployeeBean employeeBean);

    public void batchEmployee(ArrayList<EmployeeBean> empList);

    public void registerEmployee(EmployeeBean employeeBean);
    
    public void removeEmployee(EmployeeBean employeeBean);

}

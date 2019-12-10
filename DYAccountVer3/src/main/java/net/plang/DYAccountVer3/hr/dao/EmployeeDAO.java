package net.plang.DYAccountVer3.hr.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.plang.DYAccountVer3.hr.to.EmployeeBean;
@Mapper
public interface EmployeeDAO {

    public ArrayList<EmployeeBean> selectEmployeeList(String deptCode);

    public void updateEmployeeInfo(EmployeeBean employeeBean);

    public void updateEmployee(EmployeeBean employBean);

    public void deleteEmployee(String empCode);

    public void insertEmployee(EmployeeBean employeeBean);

    public EmployeeBean selectEmployee(String EmpCode);
}

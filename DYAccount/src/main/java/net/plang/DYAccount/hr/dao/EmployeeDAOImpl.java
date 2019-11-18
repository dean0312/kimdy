package net.plang.DYAccount.hr.dao;

import java.util.ArrayList;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;
import net.plang.DYAccount.hr.to.EmployeeBean;

public class EmployeeDAOImpl extends IBatisDAOSupport implements EmployeeDAO {

	@Override
	public EmployeeBean selectEmployee(String empCode) {
		return (EmployeeBean)this.getSqlMapClientTemplate().queryForObject("employee.selectEmployee", empCode);
	}

	@Override
	public ArrayList<EmployeeBean> selectEmployeeList(String deptCode) {
			return (ArrayList<EmployeeBean>)this.getSqlMapClientTemplate().queryForList("employee.selectEmployeeList", deptCode);
	}

	@Override
	public void updateEmployeeInfo(EmployeeBean employeeBean) {
		this.getSqlMapClientTemplate().update("employee.updateEmployeeInfo", employeeBean);
	}

	@Override
	public void updateEmployee(EmployeeBean bean) {
		this.getSqlMapClientTemplate().update("employee.updateEmployee", bean);
	}

	@Override
	public void deleteEmployee(String empCode) {
		this.getSqlMapClientTemplate().delete("employee.deleteEmployee", empCode);
	}

	public void insertEmployee(EmployeeBean employeeBean) {
		this.getSqlMapClientTemplate().insert("employee.insertEmployee", employeeBean);
	}

}
package net.plang.DYAccount.base.to;

public class SlipIreportBean {
	protected String slip_no;
	protected String reporting_date;
	protected String dept_name;
	protected String DEPT_CODE;
	protected String emp_name;
	protected String account_name;
	protected String expense_report;
	protected String left_debtor_price;
	protected String right_credits_price;
	protected String REPORTING_EMP_CODE;
	protected String JOURNAL_NO;
	protected String slip_status;

	public String getSlip_status() {
		return slip_status;
	}
	public void setSlip_status(String slip_status) {
		this.slip_status = slip_status;
	}
	public String getJOURNAL_NO() {
		return JOURNAL_NO;
	}
	public void setJOURNAL_NO(String jOURNAL_NO) {
		JOURNAL_NO = jOURNAL_NO;
	}
	public String getREPORTING_EMP_CODE() {
		return REPORTING_EMP_CODE;
	}
	public void setREPORTING_EMP_CODE(String rEPORTING_EMP_CODE) {
		REPORTING_EMP_CODE = rEPORTING_EMP_CODE;
	}
	public String getSlip_no() {
		return slip_no;
	}
	public void setSlip_no(String slip_no) {
		this.slip_no = slip_no;
	}
	public String getReporting_date() {
		return reporting_date;
	}
	public void setReporting_date(String reporting_date) {
		this.reporting_date = reporting_date;
	}

	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	public String getDEPT_CODE() {
		return DEPT_CODE;
	}
	public void setDEPT_CODE(String dEPT_CODE) {
		DEPT_CODE = dEPT_CODE;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getExpense_report() {
		return expense_report;
	}
	public void setExpense_report(String expense_report) {
		this.expense_report = expense_report;
	}
	public String getLeft_debtor_price() {
		return left_debtor_price;
	}
	public void setLeft_debtor_price(String left_debtor_price) {
		this.left_debtor_price = left_debtor_price;
	}
	public String getRight_credits_price() {
		return right_credits_price;
	}
	public void setRight_credits_price(String right_credits_price) {
		this.right_credits_price = right_credits_price;
	}
	
	
}

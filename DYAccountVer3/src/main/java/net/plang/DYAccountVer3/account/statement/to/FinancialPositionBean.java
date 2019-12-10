package net.plang.DYAccountVer3.account.statement.to;

import net.plang.DYAccountVer3.base.to.BaseBean;

public class FinancialPositionBean extends BaseBean {
    private int lev;
    private String category;
    private String accountName;
    private String accountCode;
    private String balanceDetail;
    private String balanceSummary;
    private String preBalanceDetail;
    private String preBalanceSummary;
    private int isThisYear;

    public int getLev() {
        return lev;
    }

    public void setLev(int lev) {
        this.lev = lev;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getBalanceDetail() {
        return balanceDetail;
    }

    public void setBalanceDetail(String balanceDetail) {
        this.balanceDetail = balanceDetail;
    }

    public String getBalanceSummary() {
        return balanceSummary;
    }

    public void setBalanceSummary(String balanceSummary) {
        this.balanceSummary = balanceSummary;
    }

    public String getPreBalanceDetail() {
        return preBalanceDetail;
    }

    public void setPreBalanceDetail(String preBalanceDetail) {
        this.preBalanceDetail = preBalanceDetail;
    }

    public String getPreBalanceSummary() {
        return preBalanceSummary;
    }

    public void setPreBalanceSummary(String preBalanceSummary) {
        this.preBalanceSummary = preBalanceSummary;
    }

    public int getIsThisYear() {
        return isThisYear;
    }

    public void setIsThisYear(int isThisYear) {
        this.isThisYear = isThisYear;
    }
}

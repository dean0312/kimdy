package net.plang.DYAccount.account.base.to;

import net.plang.DYAccount.base.to.BaseBean;

public class AccountControlBean extends BaseBean {
    private String accountControlCode;
    private String accountControlName;
    private String accountControlType;

    public String getAccountControlCode() {
        return accountControlCode;
    }

    public void setAccountControlCode(String accountControlCode) {
        this.accountControlCode = accountControlCode;
    }

    public String getAccountControlName() {
        return accountControlName;
    }

    public void setAccountControlName(String accountControlName) {
        this.accountControlName = accountControlName;
    }

    public String getAccountControlType() {
        return accountControlType;
    }

    public void setAccountControlType(String accountControlType) {
        this.accountControlType = accountControlType;
    }
}

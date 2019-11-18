package net.plang.DYAccount.account.statement.to;

public class TotalTrialBalanceBean {

    private int lev;
    private String accountName;
    private String accountInnerCode;
    private String debitsSumBalance;
    private String debitsSum;
    private String creditsSum;
    private String creditsSumBalance;

    public int getLev() {
        return lev;
    }

    public void setLev(int lev) {
        this.lev = lev;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountInnerCode() {
        return accountInnerCode;
    }

    public void setAccountInnerCode(String accountInnerCode) {
        this.accountInnerCode = accountInnerCode;
    }

    public String getDebitsSumBalance() {
        return debitsSumBalance;
    }

    public void setDebitsSumBalance(String debitsSumBalance) {
        this.debitsSumBalance = debitsSumBalance;
    }

    public String getDebitsSum() {
        return debitsSum;
    }

    public void setDebitsSum(String debitsSum) {
        this.debitsSum = debitsSum;
    }

    public String getCreditsSum() {
        return creditsSum;
    }

    public void setCreditsSum(String creditsSum) {
        this.creditsSum = creditsSum;
    }

    public String getCreditsSumBalance() {
        return creditsSumBalance;
    }

    public void setCreditsSumBalance(String creditsSumBalance) {
        this.creditsSumBalance = creditsSumBalance;
    }
}

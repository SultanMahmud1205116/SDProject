package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 5/15/16.
 */
public class Borrow implements java.io.Serializable {
    long borrowID;
    String bankAccount;
    float interestRate;
    double loanAmount;
    double paidLoan;
    double remainingLoan;
    float loanDuration;
    String paymentDate;
    String deadlineDate;
    String bankName;
    public long getBorrowID() {
        return borrowID;
    }
    public void setBorrowID(long borrowID) {
        this.borrowID = borrowID;
    }
    public String getBankAccount() {
        return bankAccount;
    }
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    public float getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }
    public double getLoanAmount() {
        return loanAmount;
    }
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    public double getPaidLoan() {
        return paidLoan;
    }
    public void setPaidLoan(double paidLoan) {
        this.paidLoan = paidLoan;
    }
    public double getRemainingLoan() {
        return remainingLoan;
    }
    public void setRemainingLoan(double remainingLoan) {
        this.remainingLoan = remainingLoan;
    }
    public float getLoanDuration() {
        return loanDuration;
    }
    public void setLoanDuration(float loanDuration) {
        this.loanDuration = loanDuration;
    }
    public String getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }
    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
    public Borrow(String bankAccount, float interestRate, double loanAmount, double paidLoan, double remainingLoan,
                  String paymentDate, String deadlineDate, String bankName) {
        super();
        this.bankAccount = bankAccount;
        this.interestRate = interestRate;
        this.loanAmount = loanAmount;
        this.paidLoan = paidLoan;
        this.remainingLoan = remainingLoan;
        this.paymentDate = paymentDate;
        this.deadlineDate = deadlineDate;
        this.bankName = bankName;
    }

    public Borrow( float interestRate, double loanAmount, double paidLoan, double remainingLoan,  String paymentDate, String deadlineDate, String bankName, String bankAccount) {
        //this.borrowID = borrowID;
        this.interestRate = interestRate;
        this.loanAmount = loanAmount;
        this.paidLoan = paidLoan;
        this.remainingLoan = remainingLoan;
        //this.loanDuration = loanDuration;
        this.paymentDate = paymentDate;
        this.deadlineDate = deadlineDate;
        this.bankName = bankName;
        this.bankAccount=bankAccount;
    }

    @Override
    public String toString() {
        return "Borrow [borrowID=" + borrowID + ", bankAccount=" + bankAccount + ", interestRate=" + interestRate
                + ", loanAmount=" + loanAmount + ", paidLoan=" + paidLoan + ", loanDuration=" + loanDuration
                + ", paymentDate=" + paymentDate + ", deadlineDate=" + deadlineDate + ", bankName=" + bankName + "]";
    }

}

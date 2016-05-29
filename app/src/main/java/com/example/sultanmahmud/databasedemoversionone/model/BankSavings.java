package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 5/15/16.
 */
public class BankSavings implements java.io.Serializable {
    long savingsID;
    String bankName;
    String bankAccount;
    double savingsAmount;
    float interestRate;
    String maturity;
    public long getSavingsID() {
        return savingsID;
    }
    public void setSavingsID(long savingsID) {
        this.savingsID = savingsID;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankAccount() {
        return bankAccount;
    }
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    public double getSavingsAmount() {
        return savingsAmount;
    }
    public void setSavingsAmount(double savingsAmount) {
        this.savingsAmount = savingsAmount;
    }
    public float getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }


    public String getMaturity() {
        return maturity;
    }
    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }
    public BankSavings(String bankName, String bankAccount, double savingsAmount, float interestRate,
                       String maturity) {
        super();
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.savingsAmount = savingsAmount;
        this.interestRate = interestRate;
        this.maturity = maturity;
    }


    @Override
    public String toString() {
        return "BankSavings [bankName=" + bankName + ", bankAccount=" + bankAccount + ", savingsAmount=" + savingsAmount
                + ", interestRate=" + interestRate + ", maturity=" + maturity + "]";
    }


}

package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 5/15/16.
 */
public class Income implements java.io.Serializable {
    long incomeID;
    String incomeDate;
    String incomeSource;
    double incomeAmount;
    double netTaxableAmount;
    double exemptedAmount;

    public long getIncomeID() {
        return incomeID;
    }
    public void setIncomeID(long incomeID) {
        this.incomeID = incomeID;
    }
    public String getIncomeDate() {
        return incomeDate;
    }
    public void setIncomeDate(String incomeDate) {
        this.incomeDate = incomeDate;
    }
    public String getIncomeSource() {
        return incomeSource;
    }
    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }
    public double getIncomeAmount() {
        return incomeAmount;
    }
    public void setIncomeAmount(double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public double getNetTaxableAmount() {
        return netTaxableAmount;
    }
    public void setNetTaxableAmount(double netTaxableAmount) {
        this.netTaxableAmount = netTaxableAmount;
    }
    public double getExemptedAmount() {
        return exemptedAmount;
    }
    public void setExemptedAmount(double exemptedAmount) {
        this.exemptedAmount = exemptedAmount;
    }
    public Income(String incomeDate, String incomeSource, double incomeAmount, double netTaxableAmount,
                  double exemptedAmount) {
        super();
        this.incomeDate = incomeDate;
        this.incomeSource = incomeSource;
        this.incomeAmount = incomeAmount;
        this.netTaxableAmount = netTaxableAmount;
        this.exemptedAmount = exemptedAmount;
    }
    @Override
    public String toString() {
        return "Income [incomeDate=" + incomeDate + ", incomeSource=" + incomeSource + ", incomeAmount=" + incomeAmount
                + ", netTaxableAmount=" + netTaxableAmount + ", exemptedAmount=" + exemptedAmount + "]";
    }
}

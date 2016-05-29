package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 5/15/16.
 */
public class Expenditure implements java.io.Serializable {
    long expenditureId;

    String expenditureDate;
    double expenditureAmount;
    String expenditureCategoryName;
    public String getExpenditureDate() {
        return expenditureDate;
    }
    public void setExpenditureDate(String expenditureDate) {
        this.expenditureDate = expenditureDate;
    }
    public double getExpenditureAmount() {
        return expenditureAmount;
    }
    public void setExpenditureAmount(double expenditureAmount) {
        this.expenditureAmount = expenditureAmount;
    }
    public String getExpenditureCategoryName() {
        return expenditureCategoryName;
    }
    public void setExpenditureCategoryName(String expenditureCategoryName) {
        this.expenditureCategoryName = expenditureCategoryName;
    }
    public long getExpenditureId() {
        return expenditureId;
    }
    public void setExpenditureId(long expenditureId) {
        this.expenditureId = expenditureId;
    }

    public Expenditure(String expenditureDate, double expenditureAmount, String expenditureCategoryName) {
        super();
        this.expenditureDate = expenditureDate;
        this.expenditureAmount = expenditureAmount;
        this.expenditureCategoryName = expenditureCategoryName;
    }
    @Override
    public String toString() {
        return "Expenditure [expenditureDate=" + expenditureDate + ", expenditureAmount=" + expenditureAmount
                + ", expenditureCategoryName=" + expenditureCategoryName + "]";
    }



}

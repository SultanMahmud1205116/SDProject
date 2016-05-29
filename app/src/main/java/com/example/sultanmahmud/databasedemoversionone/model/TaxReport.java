package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 5/17/16.
 */
public class TaxReport implements java.io.Serializable {
    double totalIncome;
    double exemptedExpenditure;
    double netTaxableIncome;
    double totalTax;

    public TaxReport(double totalIncome, double exemptedExpenditure, double totalTax) {
        this.totalIncome = totalIncome;
        this.exemptedExpenditure = exemptedExpenditure;
        this.totalTax = totalTax;

    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getExemptedExpenditure() {
        return exemptedExpenditure;
    }

    public void setExemptedExpenditure(double exemptedExpenditure) {
        this.exemptedExpenditure = exemptedExpenditure;
    }

    public double getNetTaxableIncome() {
        return netTaxableIncome;
    }

    public void setNetTaxableIncome(double netTaxableIncome) {
        this.netTaxableIncome = netTaxableIncome;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }


}


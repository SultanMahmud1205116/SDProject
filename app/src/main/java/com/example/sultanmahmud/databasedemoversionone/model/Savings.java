package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 5/15/16.
 */
public class Savings implements java.io.Serializable {
    String savingsCategory;
    double savingsAmount;
    String savingsDescription;
    public String getSavingsDescription() {
        return savingsDescription;
    }
    public void setSavingsDescription(String savingsDescription) {
        this.savingsDescription = savingsDescription;
    }

    public String getSavingsCategory() {
        return savingsCategory;
    }
    public void setSavingsCategory(String savingsCategory) {
        this.savingsCategory = savingsCategory;
    }
    public double getSavingsAmount() {
        return savingsAmount;
    }
    public void setSavingsAmount(double savingsAmount) {
        this.savingsAmount = savingsAmount;
    }


    public Savings(String savingsCategory, double savingsAmount, String savingsDescription) {
        super();
        this.savingsCategory = savingsCategory;
        this.savingsAmount = savingsAmount;
        this.savingsDescription = savingsDescription;
    }
    @Override
    public String toString() {
        return "Savings [savingsCategory=" + savingsCategory + ", savingsAmount=" + savingsAmount
                + ", savingsDescription=" + savingsDescription + "]";
    }

}

package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 6/7/16.
 */
public class AdminReport {

    double avgTaxableIncomeOfAllUsers;
    String cityOfUserWithMaxIncome;
    double totalForeignIncomeOfAllUsers;
    double totalZakatAmountOfAllUsers;

    @Override
    public String toString() {
        return "AdminReport{" +
                "avgTaxableIncomeOfAllUsers=" + avgTaxableIncomeOfAllUsers +
                ", cityOfUserWithMaxIncome='" + cityOfUserWithMaxIncome + '\'' +
                ", totalForeignIncomeOfAllUsers=" + totalForeignIncomeOfAllUsers +
                ", totalZakatAmountOfAllUsers=" + totalZakatAmountOfAllUsers +
                '}';
    }

    public AdminReport(double avgTaxableIncomeOfAllUsers, String cityOfUserWithMaxIncome, double totalForeignIncomeOfAllUsers, double totalZakatAmountOfAllUsers) {
        this.avgTaxableIncomeOfAllUsers = avgTaxableIncomeOfAllUsers;
        this.cityOfUserWithMaxIncome = cityOfUserWithMaxIncome;
        this.totalForeignIncomeOfAllUsers = totalForeignIncomeOfAllUsers;
        this.totalZakatAmountOfAllUsers = totalZakatAmountOfAllUsers;
    }

    public double getAvgTaxableIncomeOfAllUsers() {
        return avgTaxableIncomeOfAllUsers;
    }

    public String getCityOfUserWithMaxIncome() {
        return cityOfUserWithMaxIncome;
    }

    public double getTotalForeignIncomeOfAllUsers() {
        return totalForeignIncomeOfAllUsers;
    }

    public double getTotalZakatAmountOfAllUsers() {
        return totalZakatAmountOfAllUsers;
    }
}

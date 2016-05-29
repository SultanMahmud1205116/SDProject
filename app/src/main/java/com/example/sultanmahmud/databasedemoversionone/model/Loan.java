package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 5/15/16.
 */
public class Loan implements java.io.Serializable {
    long loanID;
    String dateGiven;
    double loanAmount;
    String dateToTake;
    String loanReciever;
    public String getDateGiven() {
        return dateGiven;
    }
    public void setDateGiven(String dateGiven) {
        this.dateGiven = dateGiven;
    }
    public double getLoanAmount() {
        return loanAmount;
    }
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    public String getDateToTake() {
        return dateToTake;
    }
    public void setDateToTake(String dateToTake) {
        this.dateToTake = dateToTake;
    }
    public String getLoanReciever() {
        return loanReciever;
    }
    public void setLoanReciever(String loanReciever) {
        this.loanReciever = loanReciever;
    }

    public Loan(String dateGiven, double loanAmount, String dateToTake, String loanReciever) {
        super();
        this.dateGiven = dateGiven;
        this.loanAmount = loanAmount;
        this.dateToTake = dateToTake;
        this.loanReciever = loanReciever;
    }

    @Override
    public String toString() {
        return "Loan [dateGiven=" + dateGiven + ", loanAmount=" + loanAmount + ", dateToTake=" + dateToTake
                + ", loanReciever=" + loanReciever + "]";
    }

}

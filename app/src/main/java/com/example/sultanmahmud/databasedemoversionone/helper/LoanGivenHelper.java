package com.example.sultanmahmud.databasedemoversionone.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sultanmahmud.databasedemoversionone.model.Loan;

import java.util.ArrayList;

/**
 * Created by sultanmahmud on 5/26/16.
 */
public class LoanGivenHelper {
    public static final String LOAN_ID="loan_id";
    public static final String GIVEN_BY="given_by";
    public static final String GIVEN_TO="given_to";
    public static final String START_DATE="start_date";
    public static final String END_DATE="end_date";
    public static final String AMOUNT="amount";
    public static final String LOAN_GIVEN_TABLE="loan_given";

    public ArrayList<Loan> getLoansGiven(SQLiteDatabase sqLiteDatabase, int userID) {
        ArrayList<Loan> loanArrayList = new ArrayList<>();
        String selectQuery = "SELECT  given_to, start_date, end_date, amount FROM loan_given WHERE given_by=" + userID;
        //String dateGiven, double loanAmount, String dateToTake, String loanReciever
        Cursor c = sqLiteDatabase.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                String givenTo = c.getString(0);
                String startDate = c.getString(1);
                String endDate = c.getString(2);
                double amount = Double.parseDouble(c.getString(3));
                Loan loan = new Loan(startDate, amount, endDate, givenTo);
                loanArrayList.add(loan);
            } while (c.moveToNext());
        }
        c.close();


        return loanArrayList;

    }

    public void addLoansGiven(SQLiteDatabase sqLiteDatabase, int userID, int newLoanID, Loan loan) {

//        String insertQuery = "INSERT INTO loan_given (loan_id, given_by, given_to, start_date, end_date, amount)  values (" + newLoanID+
//        "," + userID + ",'" + loan.getLoanReciever() + "'," + loan.getDateGiven() + "," + loan.getDateToTake() + "," + loan.getLoanAmount() + ")";
        ContentValues contentValues= new ContentValues();
        contentValues.put(LOAN_ID,newLoanID);
        contentValues.put(GIVEN_BY,userID);
        contentValues.put(GIVEN_TO,loan.getLoanReciever());
        contentValues.put(START_DATE,loan.getDateGiven());
        contentValues.put(END_DATE,loan.getDateToTake());
        contentValues.put(AMOUNT,loan.getLoanAmount());


        sqLiteDatabase.insert(LOAN_GIVEN_TABLE,null,contentValues);
        sqLiteDatabase.close();

        return ;



    }
}

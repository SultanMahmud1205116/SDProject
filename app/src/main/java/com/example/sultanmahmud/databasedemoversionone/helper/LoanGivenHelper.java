package com.example.sultanmahmud.databasedemoversionone.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sultanmahmud.databasedemoversionone.model.Loan;

import java.util.ArrayList;

/**
 * Created by sultanmahmud on 5/26/16.
 */
public class LoanGivenHelper {

    public ArrayList<Loan> getLoansGiven(SQLiteDatabase sqLiteDatabase, int userID){
         ArrayList<Loan> loanArrayList=new ArrayList<>();
         String selectQuery="SELECT  given_to, start_date, end_date, amount FROM loan_given WHERE given_by="+userID;
        //String dateGiven, double loanAmount, String dateToTake, String loanReciever
        Cursor c =sqLiteDatabase.rawQuery(selectQuery,null);
        if(c.moveToFirst()){
            do{
                String givenTo=c.getString(0);
                String startDate=c.getString(1);
                String endDate=c.getString(2);
                double amount=Double.parseDouble(c.getString(3));
                Loan loan= new Loan(startDate,amount,endDate,givenTo);
                loanArrayList.add(loan);
            }while(c.moveToNext());
        }
        c.close();


        return loanArrayList;

    }
}

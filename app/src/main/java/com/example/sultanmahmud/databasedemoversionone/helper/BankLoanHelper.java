package com.example.sultanmahmud.databasedemoversionone.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sultanmahmud.databasedemoversionone.model.Borrow;

import java.util.ArrayList;

/**
 * Created by sultanmahmud on 5/17/16.
 */
public class BankLoanHelper {


    float loanInterest;
    String paymentDate;
    double loanAmount;
    double paidAmount;
    String deadLine;
    String accountNumber;
    String bankName;

    public ArrayList<Borrow> getBorrowArrayList(SQLiteDatabase sqLiteDatabase,int userID){
        ArrayList<Borrow> borrowArrayList=new ArrayList<Borrow>();
        /*String bankAccount, float interestRate, double loanAmount, double paidLoan, double remainingLoan,
                  String paymentDate, String deadlineDate, String bankName*/


        String selectQuery="select bl.loan_interest,bl.payment_date,bl.loan_amount,bl.paid_amount,bl.deadline,bl.account_number,b.bank_name from bank_loan bl, bank b where b.bank_id=bl.bank_id and bl.user_id="+userID;
        Cursor c=sqLiteDatabase.rawQuery(selectQuery,null);

        if(c.moveToFirst()){
            do{
                loanInterest=c.getFloat(0);
                paymentDate=c.getString(1);
                loanAmount=c.getDouble(2);
                paidAmount=c.getDouble(3);
                deadLine=c.getString(4);
                accountNumber=c.getString(5);
                bankName=c.getString(6);

                Borrow borrow= new Borrow(accountNumber,loanInterest,loanAmount,paidAmount,(loanAmount-paidAmount),paymentDate,deadLine,bankName);
                borrowArrayList.add(borrow);


            }while(c.moveToNext());

            c.close();
        }

        return borrowArrayList;

    }
}

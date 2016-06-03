package com.example.sultanmahmud.databasedemoversionone.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sultanmahmud.databasedemoversionone.model.Borrow;

import java.util.ArrayList;

/**
 * Created by sultanmahmud on 5/17/16.
 */
public class BankLoanHelper {

    //INSERT INTO bank_loan (bank_id, user_id, loan_interest, payment_date, loan_amount, paid_amount, deadline, account_number)  values (

    float loanInterest;
    String paymentDate;
    double loanAmount;
    double paidAmount;
    String deadLine;
    String accountNumber;
    String bankName;
    private static final String BANK_LOAN_TABLE="bank_loan";
    private static final String BANK_ID="bank_id";
    private static final String USER_ID="user_id";
    private static final String LOAN_INTEREST="loan_interest";
    private static final String PAYMENT_DATE="payment_date";
    private static final String LOAN_AMOUNT="loan_amount";
    private static final String PAID_AMOUNT="paid_amount";
    private static final String DEADLINE="deadline";
    private static final String ACCOUNT_NUMBER="account_number";


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
    public void addBankLoan(SQLiteDatabase sqLiteDatabase,int userID,int bankID, Borrow borrow, int bankLoanID){
        ContentValues contentValues = new ContentValues();
        //INSERT INTO bank_loan (bank_id, user_id, loan_interest, payment_date, loan_amount, paid_amount,
        // deadline, account_number)  values (
        //contentValues.put("bank_loan_id",bankLoanID);
        contentValues.put(BANK_ID, bankID);
        contentValues.put(USER_ID, userID);
        contentValues.put(LOAN_INTEREST,borrow.getInterestRate());
        contentValues.put(PAYMENT_DATE,borrow.getPaymentDate());
        contentValues.put(LOAN_AMOUNT,borrow.getLoanAmount());
        contentValues.put(PAID_AMOUNT,borrow.getPaidLoan());
        contentValues.put(DEADLINE,borrow.getDeadlineDate());
        contentValues.put(ACCOUNT_NUMBER,borrow.getBankAccount());
        sqLiteDatabase.insert(BANK_LOAN_TABLE,null,contentValues);
        sqLiteDatabase.close();
        return;

    }
}

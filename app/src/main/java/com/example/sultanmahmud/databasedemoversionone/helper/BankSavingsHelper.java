package com.example.sultanmahmud.databasedemoversionone.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sultanmahmud.databasedemoversionone.model.BankSavings;

import java.util.ArrayList;

/**
 * Created by sultanmahmud on 5/17/16.
 */
public class BankSavingsHelper {
    // bank_savings (bank_id, user_id, interest_rate, maturity_date, total_savings_amount, account_number)
    private static final String BANK_SAVINGS_TABLE="bank_savings";
    private static final String BANK_ID="bank_id";
    private static final String USER_ID="user_id";
    private static final String INTEREST_RATE="interest_rate";
    private static final String MATURITY_DATE="maturity_date";
    private static final String TOTAL_SAVINGS_AMOUNT="total_savings_amount";
    private static final String ACCOUNT_NUMBER="account_number";




    public ArrayList<BankSavings> getAllBankSavings(SQLiteDatabase sqLiteDatabase, int userID){
        ArrayList<BankSavings> bankSavingsArrayList= new ArrayList<BankSavings>();
        String selectQuery="SELECT bs.interest_rate interest, bs.maturity_date mature_date, bs.total_savings_amount savings,bs.account_number accnum, b.bank_name bname FROM bank_savings bs , bank b WHERE bs.bank_id=b.bank_id and bs.user_id="+userID;
        Cursor c = sqLiteDatabase.rawQuery(selectQuery,null);
        if(c.moveToFirst()){
            do{
                String bankName=c.getString(4);
                String bankAccount=c.getString(3);
                double savedAmount=Double.parseDouble(c.getString(2));
                float interestRate=Float.parseFloat(c.getString(0));
                String maturity=c.getString(1);
                BankSavings bankSavings= new BankSavings(bankName,bankAccount,savedAmount,interestRate,maturity);
                bankSavingsArrayList.add(bankSavings);

            }while(c.moveToNext());
        }

        return bankSavingsArrayList;

    }
    public void addBankSavings(SQLiteDatabase sqLiteDatabase, int userID, BankSavings bankSavings, int bankID, int savingsID){
        ContentValues contentValues= new ContentValues();
        //contentValues.put(BANK_SAVINGS_TABLE, );
        // bank_savings (bank_id, user_id, interest_rate, maturity_date, total_savings_amount, account_number)
        contentValues.put(BANK_ID,bankID);
        contentValues.put(USER_ID,userID);
        contentValues.put(INTEREST_RATE,bankSavings.getInterestRate());
        contentValues.put(MATURITY_DATE,bankSavings.getMaturity());
        contentValues.put(TOTAL_SAVINGS_AMOUNT,bankSavings.getSavingsAmount());
        contentValues.put(ACCOUNT_NUMBER,bankSavings.getBankAccount());
        sqLiteDatabase.insert(BANK_SAVINGS_TABLE,null,contentValues);
        sqLiteDatabase.close();
        return;

    }
}

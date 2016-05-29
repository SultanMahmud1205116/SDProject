package com.example.sultanmahmud.databasedemoversionone.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sultanmahmud.databasedemoversionone.model.BankSavings;

import java.util.ArrayList;

/**
 * Created by sultanmahmud on 5/17/16.
 */
public class BankSavingsHelper {



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
}

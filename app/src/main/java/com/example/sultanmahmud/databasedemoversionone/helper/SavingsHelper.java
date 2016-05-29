package com.example.sultanmahmud.databasedemoversionone.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sultanmahmud.databasedemoversionone.model.Savings;

import java.util.ArrayList;

/**
 * Created by sultanmahmud on 5/26/16.
 */
public class SavingsHelper {

    public ArrayList<Savings> getSavings(SQLiteDatabase sqLiteDatabase, int userID){

        ArrayList<Savings> savingsArrayList= new ArrayList<>();
        String selectQuery="select s.savings_amount,s.savings_description,s2.savings_category_name from savings s , savings_category s2 where s.savings_category_id=s2.savings_category_id and s.user_id="+userID;
        Cursor c = sqLiteDatabase.rawQuery(selectQuery,null);
        if(c.moveToFirst()){
            do{
                /*
                String savingsCategory, double savingsAmount, String savingsDescription
                * */

                String savingsCategory=c.getString(2);
                double savingsAmount=Double.parseDouble(c.getString(0));
                String savingsDescription=c.getString(1);
                Savings savings= new Savings(savingsCategory,savingsAmount,savingsDescription);
                savingsArrayList.add(savings);
            }while(c.moveToNext());
        }


        return  savingsArrayList;

    }
}

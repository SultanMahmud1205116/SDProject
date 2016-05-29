package com.example.sultanmahmud.databasedemoversionone.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sultanmahmud.databasedemoversionone.model.Income;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by sultanmahmud on 5/26/16.
 */
public class IncomeHelper {

    public ArrayList<Income> getIncome(SQLiteDatabase sqLiteDatabase, int userID){
        ArrayList<Income> incomeArrayList= new ArrayList<>();
        String selectQuery="SELECT  i.income_date, i.income_amount, i.exempted_amount, i.net_taxable_amount, ic.income_source_category_name FROM income i, income_source_category ic WHERE i.income_source_category_id=ic.income_source_category_id and i.user_id="+userID;
        /*
        * public Income(String incomeDate, String incomeSource, double incomeAmount, double netTaxableAmount,
                  double exemptedAmount)
                  */

        Cursor c=sqLiteDatabase.rawQuery(selectQuery,null);
        if(c.moveToFirst()){
            do{
                String incomeDate= c.getString(0);
                String incomeSource=c.getString(4);
                double incomeAmount=Double.parseDouble(c.getString(1));
                double netTaxableAmount=Double.parseDouble(c.getString(3));
                double exemptedAmount=Double.parseDouble(c.getString(2));
                Income income=new Income(incomeDate,incomeSource,incomeAmount,netTaxableAmount,exemptedAmount);
                incomeArrayList.add(income);
            }while(c.moveToNext());

        }
        c.close();
        return incomeArrayList;
    }
}

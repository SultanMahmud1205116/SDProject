package com.example.sultanmahmud.databasedemoversionone.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sultanmahmud.databasedemoversionone.model.Income;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by sultanmahmud on 5/26/16.
 */
public class IncomeHelper {
    //INSERT INTO income (income_source_category_id,income_date,user_id,
    // income_amount, exempted_amount,net_taxable_amount)
    private static final String INCOME_TABLE="income";
    private static final String INCOME_SOURCE_CATEGORY_ID="income_source_category_id";
    private static final String INCOME_DATE="income_date";
    private static final String USER_ID="user_id";
    private static final String INCOME_AMOUNT="income_amount";
    private static final String EXEMPTED_AMOUNT="exempted_amount";
    private static final String NET_TAXABLE_AMOUNT="net_taxable_amount";



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

    public void addIncome(int userID, int incomeCategoryID, Income income,SQLiteDatabase sqLiteDatabase){
        //INSERT INTO income (income_source_category_id,income_date,user_id,
        // income_amount, exempted_amount,net_taxable_amount)
        ContentValues contentValues= new ContentValues();
        contentValues.put(INCOME_SOURCE_CATEGORY_ID,incomeCategoryID);
        contentValues.put(INCOME_DATE,income.getIncomeDate());
        contentValues.put(USER_ID,userID);
        contentValues.put(INCOME_AMOUNT,income.getIncomeAmount());
        contentValues.put(EXEMPTED_AMOUNT,income.getExemptedAmount());
        contentValues.put(NET_TAXABLE_AMOUNT,income.getNetTaxableAmount());
        sqLiteDatabase.insert(INCOME_TABLE,null,contentValues);

        return;
    }
}

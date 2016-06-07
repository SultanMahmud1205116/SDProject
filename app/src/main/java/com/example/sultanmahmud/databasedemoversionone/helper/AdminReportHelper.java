package com.example.sultanmahmud.databasedemoversionone.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sultanmahmud.databasedemoversionone.model.AdminReport;

/**
 * Created by sultanmahmud on 6/7/16.
 */
public class AdminReportHelper {

    public AdminReport getAdminReport(SQLiteDatabase sqLiteDatabase){
        AdminReport adminReport;
        double avgTaxableIncomeOfAllUsers=0;
        String cityOfUserWithMaxIncome="~";
        double totalForeignIncomeOfAllUsers=0;
        double totalZakatAmountOfAllUsers=0;

        String selectQuery1="SELECT AVG(net_taxable_amount) FROM income";
        String selectQuery2="SELECT city from user where user_id = (SELECT  user_id from income WHERE income_amount = (\n" +
                "SELECT max(income_amount) FROM income))";
        String selectQuery3="SELECT SUM(income_amount) FROM income WHERE income_source_category_id =24";
        String selectQuery4="SELECT SUM(expenditure_amount) FROM expenditure WHERE expenditure_category_id = 22";
        Cursor cursor= sqLiteDatabase.rawQuery(selectQuery1,null);
        if(cursor.moveToFirst()){
            do{
                avgTaxableIncomeOfAllUsers=Double.parseDouble(cursor.getString(0));

            }while(cursor.moveToNext());
        }
        cursor.close();

        Cursor cursor1= sqLiteDatabase.rawQuery(selectQuery2,null);
        if(cursor1.moveToFirst()){
            do{
                cityOfUserWithMaxIncome=cursor1.getString(0);

            }while(cursor1.moveToNext());
        }
        cursor1.close();


        Cursor cursor2= sqLiteDatabase.rawQuery(selectQuery3,null);
        if(cursor2.moveToFirst()){
            do{
                totalForeignIncomeOfAllUsers=Double.parseDouble(cursor2.getString(0));

            }while(cursor2.moveToNext());
        }
        cursor2.close();


        Cursor cursor3= sqLiteDatabase.rawQuery(selectQuery4,null);
        if(cursor3.moveToFirst()){
            do{
                totalZakatAmountOfAllUsers=Double.parseDouble(cursor3.getString(0));

            }while(cursor3.moveToNext());
        }
        cursor3.close();
        adminReport=new AdminReport( avgTaxableIncomeOfAllUsers,  cityOfUserWithMaxIncome,  totalForeignIncomeOfAllUsers,  totalZakatAmountOfAllUsers);

        Log.d("$$$$$$$$",adminReport.toString());
        return adminReport;
    }
}

package com.example.sultanmahmud.databasedemoversionone.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sultanmahmud.databasedemoversionone.model.Expenditure;
import com.example.sultanmahmud.databasedemoversionone.model.Income;

import java.util.ArrayList;

/**
 * Created by sultanmahmud on 5/26/16.
 */
public class ExpenditureHelper {
    public ArrayList<Expenditure> getExpenditure(SQLiteDatabase sqLiteDatabase, int userID){
        ArrayList<Expenditure> expenditureArrayList= new ArrayList<>();
        String selectQuery="SELECT  exp.date date, exp.expenditure_amount amount, eid.expenditure_category_name expencatname FROM expenditure exp, expenditure_category eid WHERE exp.expenditure_category_id=eid.expenditure_category_id and exp.user_id="+userID;

        /*
        String expenditureDate, double expenditureAmount, String expenditureCategoryName
        * */
        Cursor c= sqLiteDatabase.rawQuery(selectQuery,null);
        if(c.moveToFirst()){
            do{
                String expenditureDate=c.getString(0);
                double expenditureAmount=Double.parseDouble(c.getString(1));
                String expenditureCategoryName=c.getString(2);

                Expenditure expenditure= new Expenditure(expenditureDate,expenditureAmount,expenditureCategoryName);
                expenditureArrayList.add(expenditure);
            }while(c.moveToNext());
        }

        return expenditureArrayList;
    }
}

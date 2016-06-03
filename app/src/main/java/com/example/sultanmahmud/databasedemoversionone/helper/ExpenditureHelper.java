package com.example.sultanmahmud.databasedemoversionone.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sultanmahmud.databasedemoversionone.model.Expenditure;
import com.example.sultanmahmud.databasedemoversionone.model.Income;

import java.util.ArrayList;

/**
 * Created by sultanmahmud on 5/26/16.
 */
public class ExpenditureHelper {
    //expenditure (expenditure_category_id,date,user_id, expenditure_amount)  values (

    private static final String EXPENDITURE_TABLE="expenditure";
    private static final String EXPENDITURE_CATEGORY_ID="expenditure_category_id";
    private static final String EXPENDITURE_DATE="date";
    private static final String USER_ID="user_id";
    private static final String EXPENDITURE_AMOUNT="expenditure_amount";
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

    public void addExpenditure(int userID, int expenditureCategoryID, Expenditure expenditure,SQLiteDatabase sqLiteDatabase){
        //expenditure (expenditure_category_id,date,user_id, expenditure_amount)  values (
        ContentValues contentValues= new ContentValues();
        contentValues.put(EXPENDITURE_CATEGORY_ID,expenditureCategoryID);
        contentValues.put(EXPENDITURE_DATE,expenditure.getExpenditureDate());
        contentValues.put(USER_ID,userID);
        contentValues.put(EXPENDITURE_AMOUNT,expenditure.getExpenditureAmount());
        sqLiteDatabase.insert(EXPENDITURE_TABLE,null,contentValues);


        return;






    }

}

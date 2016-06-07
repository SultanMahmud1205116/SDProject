package com.example.sultanmahmud.databasedemoversionone.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sultanmahmud.databasedemoversionone.model.TaxCalculationParameter;

/**
 * Created by sultanmahmud on 6/6/16.
 */
public class AdminHelper {


    double firstSlotIfFreedomFighter;
    double firstSlotIfRetired;
    double firstSlotIfFemale;
    double regularFirstSlot;
    double secondSlot;
    double thirdSlot;
    double fourthSlot;
    double fifthSlot;
    double firstSlotMultiplier;
    double secondSlotMultiplier;
    double thirdSlotMultiplier;
    double fourthSlotMultiplier;
    double fifthSlotMultiplier;
    double taxLowestHighestValue;
    double taxLowestSecondHighestValue;
    double taxLowestLowestValue;
    int year;
    String taxLowestHighestPlace;
    String taxLowestSecondHighestPlace;

    //String adminName,adminPassword;
    public int getAdminID(String adminName, String adminPassword, SQLiteDatabase sqLiteDatabase) {

        int returnValue = -1;
        String selectQuery = "select admin_user_name from admin where admin_name='" + adminName + "' and password='" + adminPassword + "'";
        //String selectQuery="select * from admin";
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                returnValue = Integer.parseInt(cursor.getString(0));
                //Log.d("%%%%%%%",(cursor.getString(0)+" , "+cursor.getString(1)+" , "+cursor.getString(2)));

            } while (cursor.moveToNext());

            return returnValue;
        }

        return -1;
    }


    public TaxCalculationParameter getTaxCalculationParameter(SQLiteDatabase sqLiteDatabase) {
        TaxCalculationParameter taxCalculationParameter;
        String selectQuery = "select * from tax_calculation_parameters";
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                firstSlotIfFreedomFighter = Double.parseDouble(cursor.getString(0));
                firstSlotIfRetired = Double.parseDouble(cursor.getString(1));
                firstSlotIfFemale = Double.parseDouble(cursor.getString(2));
                regularFirstSlot = Double.parseDouble(cursor.getString(3));
                secondSlot = Double.parseDouble(cursor.getString(4));
                thirdSlot = Double.parseDouble(cursor.getString(5));
                fourthSlot = Double.parseDouble(cursor.getString(6));
                fifthSlot = Double.parseDouble(cursor.getString(7));
                firstSlotMultiplier = Double.parseDouble(cursor.getString(8));
                secondSlotMultiplier = Double.parseDouble(cursor.getString(9));
                thirdSlotMultiplier = Double.parseDouble(cursor.getString(10));
                fourthSlotMultiplier = Double.parseDouble(cursor.getString(11));
                fifthSlotMultiplier = Double.parseDouble(cursor.getString(12));
                taxLowestHighestValue = Double.parseDouble(cursor.getString(13));
                taxLowestSecondHighestValue = Double.parseDouble(cursor.getString(14));
                taxLowestLowestValue = Double.parseDouble(cursor.getString(15));
                year = Integer.parseInt(cursor.getString(16));
                taxLowestHighestPlace = cursor.getString(17);
                taxLowestSecondHighestPlace = cursor.getString(18);

            } while (cursor.moveToNext());

            taxCalculationParameter= new TaxCalculationParameter( firstSlotIfFreedomFighter,  firstSlotIfRetired,  firstSlotIfFemale,  regularFirstSlot,  secondSlot,  thirdSlot,  fourthSlot,  fifthSlot,  firstSlotMultiplier,  secondSlotMultiplier,  thirdSlotMultiplier,  fourthSlotMultiplier,  fifthSlotMultiplier,  taxLowestHighestValue,  taxLowestSecondHighestValue,  taxLowestLowestValue,  year,  taxLowestHighestPlace,  taxLowestSecondHighestPlace) ;
            return taxCalculationParameter;

        }
        return null;

    }
}

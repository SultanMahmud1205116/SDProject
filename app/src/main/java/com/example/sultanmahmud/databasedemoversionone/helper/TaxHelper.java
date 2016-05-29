package com.example.sultanmahmud.databasedemoversionone.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sultanmahmud.databasedemoversionone.model.TaxCalculator;
import com.example.sultanmahmud.databasedemoversionone.model.TaxReport;

/**
 * Created by sultanmahmud on 5/17/16.
 */
public class TaxHelper {

    double firstSlotIfFreedomFighter,  firstSlotIfRetired,  firstSlotIfFemale,  regularFirstSlot,  secondSlot,  thirdSlot,  fourthSlot,  fifthSlot,  firstSlotMultiplier,  secondSlotMultiplier,  thirdSlotMultiplier,  forthSlotMultiplier,  fifthSlotMultiplier;
    int taxLowestHighestValue,  taxLowestSecondHighestValue,  taxLowestLowestValue,  age;
    String gender,  city,  retirementStatus,  freedomFighterStatus,  year,  taxLowestHighestPlaceString,  taxLowestSecondHighestPlaceString;
    double totalIncome,  exemptedExpenditure;







    public TaxReport getTaxReport(SQLiteDatabase sqLiteDatabase,int userID){


       String taxCalculationParameterQuery="select * from tax_calculation_parameters";
        Cursor c1=sqLiteDatabase.rawQuery(taxCalculationParameterQuery,null);
       if(c1.moveToFirst()){

        do{
            firstSlotIfFreedomFighter=c1.getDouble(0);
            firstSlotIfRetired=c1.getDouble(1);
            firstSlotIfFemale=c1.getDouble(2);
            regularFirstSlot=c1.getDouble(3);
            secondSlot=c1.getDouble(4);
            thirdSlot=c1.getDouble(5);
            fourthSlot=c1.getDouble(6);
            fifthSlot=c1.getDouble(7);
            firstSlotMultiplier=c1.getDouble(8);
            secondSlotMultiplier=c1.getDouble(9);
            thirdSlotMultiplier=c1.getDouble(10);
            forthSlotMultiplier=c1.getDouble(11);
            fifthSlotMultiplier=c1.getDouble(12);
            taxLowestHighestValue=c1.getInt(13);
            taxLowestSecondHighestValue=c1.getInt(14);
            taxLowestLowestValue=c1.getInt(15);
            year=c1.getString(16);
            taxLowestHighestPlaceString=c1.getString(17);
            taxLowestSecondHighestPlaceString=c1.getString(18);

        }while(c1.moveToNext());
        c1.close();
       }

        String selectQueryFromUserTable="select gender,city,retirement_status,freedom_fighter_status,age from user where user_id ="+userID;

        Cursor c2=sqLiteDatabase.rawQuery(selectQueryFromUserTable,null);

        if(c2.moveToFirst()){

            do{
                gender=c2.getString(0);
                city=c2.getString(1);
                retirementStatus=c2.getString(2);
                freedomFighterStatus=c2.getString(3);
                age=c2.getInt(4);


            }while (c2.moveToNext());
            c2.close();
        }

        String getTotalIncomeQuery="select sum(net_taxable_amount)  tax from income where user_id="+userID;
        String getExemptedIncomeQuery="select (sum(expenditure_amount)*(0.15))  exemption from expenditure where expenditure_category_id in (16,19,20,21,22) and user_id="+userID;

        Cursor c3=sqLiteDatabase.rawQuery(getTotalIncomeQuery,null);


        if(c3.moveToFirst()){

            do{
                totalIncome=c3.getDouble(0);


            }while (c3.moveToNext());
            c3.close();
        }
        Cursor c4=sqLiteDatabase.rawQuery(getExemptedIncomeQuery,null);
        if(c4.moveToFirst()){
            do{
                exemptedExpenditure=c4.getDouble(0);
            }while(c4.moveToNext());

            c4.close();
        }













       //double firstSlotIfFreedomFighter, double firstSlotIfRetired, double firstSlotIfFemale, double regularFirstSlot, double secondSlot, double thirdSlot, double fourthSlot, double fifthSlot, double firstSlotMultiplier, double secondSlotMultiplier, double thirdSlotMultiplier, double forthSlotMultiplier, double fifthSlotMultiplier, int taxLowestHighestValue, int taxLowestSecondHighestValue, int taxLowestLowestValue, int age, String gender, String city, String retirementStatus, String freedomFighterStatus, String year, String taxLowestHighestPlaceString, String taxLowestSecondHighestPlaceString,  double totalIncome, double exemptedExpenditure
       TaxCalculator taxCalculator= new TaxCalculator( firstSlotIfFreedomFighter,  firstSlotIfRetired,  firstSlotIfFemale,  regularFirstSlot,  secondSlot,  thirdSlot,  fourthSlot,  fifthSlot,  firstSlotMultiplier,  secondSlotMultiplier,  thirdSlotMultiplier,  forthSlotMultiplier,  fifthSlotMultiplier,  taxLowestHighestValue,  taxLowestSecondHighestValue,  taxLowestLowestValue,  age,  gender,  city,  retirementStatus,  freedomFighterStatus,  year,  taxLowestHighestPlaceString,  taxLowestSecondHighestPlaceString,  totalIncome,  exemptedExpenditure);
        double calculatedTax=taxCalculator.getCalculatedTax();
       TaxReport taxReport= new TaxReport(totalIncome,exemptedExpenditure,calculatedTax);
       return taxReport;

   }




}


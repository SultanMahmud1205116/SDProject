package com.example.sultanmahmud.databasedemoversionone.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sultanmahmud.databasedemoversionone.model.User;

import java.util.ArrayList;


/**
 * Created by sultanmahmud on 5/15/16.
 */
public class UserHelper {

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String AGE = "age";
    private static final String GENDER = "gender";
    private static final String CITY = "city";
    private static final String RETIREMENT_STATUS = "retirement_status";
    private static final String FREEDOM_FIGHTER_STATUS = "freedom_fighter_status";
    private static final String TIN = "tin";

    public long createUser(User user, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(NAME, user.getName());
        values.put(EMAIL, user.getEmail());
        values.put(PASSWORD, user.getPassword());
        values.put(AGE, user.getAge());
        values.put(GENDER, user.getGender());
        values.put(CITY, user.getCity());
        values.put(RETIREMENT_STATUS, user.getRetirementStatus());
        values.put(FREEDOM_FIGHTER_STATUS, user.getFreedomFighterStatus());
        values.put(TIN, user.getTin());


        long id=db.insert(DatabaseHelper.DATABASE_NAME,null,values);
        return id;

    }


    public ArrayList<User> getAllUsers(SQLiteDatabase db){
        ArrayList<User> userArrayList= new ArrayList<User>();
        String selectQuery="select * from user";
        //Log.e(DatabaseHelper.LOG,selectQuery);
        // here you have to send a readable database
        Cursor c= db.rawQuery(selectQuery,null);
        if (c.moveToFirst()) {
            do {
                /*
                Todo td = new Todo();
                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                td.setNote((c.getString(c.getColumnIndex(KEY_TODO))));
                td.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

                // adding to todo list
                todos.add(td);
                */
                int userID=c.getInt(c.getColumnIndex("user_id"));
                String name=c.getString(c.getColumnIndex(NAME));
                String email=c.getString(c.getColumnIndex(EMAIL));
                String password=c.getString(c.getColumnIndex(PASSWORD));
                // check the DoB
                int age=c.getInt(c.getColumnIndex(AGE));
                String gender=c.getString(c.getColumnIndex(GENDER));
                String city=c.getString(c.getColumnIndex(CITY));
                String retirementStatus=c.getString(c.getColumnIndex(RETIREMENT_STATUS));
                String freedomFighterStatus=c.getString(c.getColumnIndex((FREEDOM_FIGHTER_STATUS)));
                String tin=c.getString(c.getColumnIndex(TIN));
                User user=new User(userID,name,password,email,age,gender,city,retirementStatus,freedomFighterStatus,tin);
                userArrayList.add(user);




            } while (c.moveToNext());
        }

        return userArrayList;

    }
    public int getUserId(String userMail, String password, SQLiteDatabase db){

        int returnValue=-1;
        String selectQuery="select * from user where email = '"+userMail+"' and password = '"+password+"'";
        Log.d("USer mail: ",userMail);
        Log.d("Password: ",password);
        Cursor c= db.rawQuery(selectQuery,null);
        //Log.d("*** this is the count",""+c.getCount());
        if(c.moveToFirst()){

            do{
                //returnValue=c.getInt(c.getColumnIndex("user_id"));
                returnValue=Integer.parseInt(c.getString(0)) ;

            }while(c.moveToNext());


            //returnValue=c.getInt(c.getColumnIndex("user_id"));
            //System.out.println("****************** THE return value is:  "+returnValue);
            return returnValue;
        }

        return -1;

    }
}

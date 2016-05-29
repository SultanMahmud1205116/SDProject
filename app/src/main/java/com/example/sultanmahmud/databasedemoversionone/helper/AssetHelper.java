package com.example.sultanmahmud.databasedemoversionone.helper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sultanmahmud.databasedemoversionone.model.*;

import java.util.ArrayList;



/**
 * Created by sultanmahmud on 5/15/16.
 */
public class AssetHelper {
    private static final String ID="asset_id";
    private static final String ASSET_CATEGORY_ID="asset_category_id";
    private static final String ASSET_NAME="assetname";
    private static final String USER_ID="user_id";
    private static final String ASSET_VALUE="asset_value";
    //ArrayList<Asset> assetArrayList;



    public ArrayList<Asset> getAllAssets(SQLiteDatabase db, int userID){

        //String selectQuery="SELECT * FROM ASSET where user_id="+userID;
        ArrayList<Asset> assetArrayList= new ArrayList<Asset>();
        String userIdString=""+userID;
        String selectQuery="select * from asset where user_id="+userID;
        Cursor c = db.rawQuery(selectQuery,null);
        // looping through all rows and adding to list
        //Log.d("%%%%%%%%%%%", ""+c.getCount());
        if (c.moveToFirst()) {
            do {
                /*
                Todo td = new Todo();

                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                td.setNote((c.getString(c.getColumnIndex(KEY_TODO))));
                td.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

                // adding to todo list
                todos.add(td);

                int id=c.getInt(c.getColumnIndex(ID));
                int asset_category_id=c.getInt(c.getColumnIndex(ASSET_CATEGORY_ID));
                String asset_name=c.getString(c.getColumnIndex(ASSET_NAME));
                int user_id=c.getInt(c.getColumnIndex(USER_ID));
                int asset_value=c.getInt(c.getColumnIndex(ASSET_VALUE));
                Asset asset = new Asset(asset_name,"hello",asset_value);
                */

                String assetName=c.getString(2);
                Log.d("&&&&&&&&&&&&&", ""+assetName);
                String assetCategoryName="hello";
                int assetValue=Integer.parseInt(c.getString(4));
                Asset asset= new Asset(assetName,assetCategoryName,assetValue);
                assetArrayList.add(asset);
            } while (c.moveToNext());
        }
        c.close();

        return assetArrayList;



    }




}

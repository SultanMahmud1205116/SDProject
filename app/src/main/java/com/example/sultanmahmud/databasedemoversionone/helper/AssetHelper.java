package com.example.sultanmahmud.databasedemoversionone.helper;
import android.content.ContentValues;
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
    private static final String ASSET_TABLE="asset";

    private String[] assetCategoryList={
            "business_capital",
            "director_shareholdings_in_limited_compnanies",
            "non_agricultural_property",
            "agricultural_property",
            "shares/debentures",
            "saving_certificate/unit_certificate/bond",
            "prize_bond/savings_scheme",
            "loans_given",
            "other_investment",
            "motor_vehicles",
            "jewellery",
            "furniture",
            "electronic_equipment",
            "cash_in_hand",
            "cash_in_bank",
            "other_deposits",
            "other_assets",
            "mortgages_secured_on_property_on_land",
            "unsecured_loans",
            "net_wealth_as_on_last_date_of_this_income_year",
            "net_wealth_as_on_last_date_of_prev_income_year",
            "family_expenditure",
            "source_of_funnd_Shown_return_income",
            "source_of_fund_tax_exempted",
            "source_of_fund_other_receipts",
            "Number_of_adult_children",
            "Number_of_minor_children",
            "less_liabilities"};
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
                //Log.d("&&&&&&&&&&&&&", ""+assetName);
                String assetCategoryName="hello";
                int assetValue=Integer.parseInt(c.getString(4));
                Asset asset= new Asset(assetName,assetCategoryName,assetValue);
                assetArrayList.add(asset);
            } while (c.moveToNext());
        }
        c.close();

        return assetArrayList;



    }

    public boolean createNewAsset(Asset asset,SQLiteDatabase sqLiteDatabase,int assetCategoryID, int userID){
        String assetName=asset.getAssetName();
        long assetValue=asset.getAssetvalue();
        //String addQuery="INSERT INTO asset (asset_category_id,assetname,user_id, asset_value) values ("+assetCategoryID+","+assetName+","+userID+","+assetValue+")";
        ContentValues contentValues= new ContentValues();
        contentValues.put(ASSET_CATEGORY_ID, assetCategoryID);
        contentValues.put(ASSET_NAME,assetName);
        contentValues.put(USER_ID,userID);
        contentValues.put(ASSET_VALUE,assetValue);

        sqLiteDatabase.insert(ASSET_TABLE,null,contentValues);
        sqLiteDatabase.close();





        return false;
    }


    public static void removeAsset(Asset assetToDelete, SQLiteDatabase sqLiteDatabase, int userID) {
        //int x=sqLiteDatabase.delete("asset","asset_category_id = '"+assetToDelete.getAssetCategory()+"' and assetname = '"+assetToDelete.getAssetName()+"' and asset_value = '"+assetToDelete.getAssetvalue()+"' and user_id='"+userID+"'",null);
        int x=sqLiteDatabase.delete("asset","asset_category_id = ? and assetname = ? and asset_value = ? and user_id = ?",new String[]{assetToDelete.getAssetCategory(),assetToDelete.getAssetName(),""+assetToDelete.getAssetvalue(),""+userID});
        //Log.d("#########","asset_category_id = '"+assetToDelete.getAssetCategory()+"' and assetname = '"+assetToDelete.getAssetName()+"' and asset_value = '"+assetToDelete.getAssetvalue()+"' and user_id='"+userID+"'");
        Log.d("%%%%%%%%%",""+x);
        //asset.get
    }
}

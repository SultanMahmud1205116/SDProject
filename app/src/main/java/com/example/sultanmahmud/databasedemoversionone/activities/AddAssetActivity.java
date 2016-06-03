package com.example.sultanmahmud.databasedemoversionone.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.helper.DatabaseHelper;
import com.example.sultanmahmud.databasedemoversionone.model.Asset;

import java.util.ArrayList;

public class AddAssetActivity extends AppCompatActivity {

    TextView asset_name, asset_value;

    Spinner asset_category;
    String cat,assetName,assetValue;
    Button button;
    DatabaseHelper dbh;
    int userID;
    Asset asset;

    //String[] category = {"business_capital","loans_given","motor_vehicle"};
    String[] category ={"business_capital",
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_asset);
        asset_name = (TextView) findViewById(R.id.asset_name);
        asset_value = (TextView) findViewById(R.id.value);
        asset_category = (Spinner) findViewById(R.id.asset_cat);
        button=(Button) findViewById(R.id.save);
        userID=getIntent().getIntExtra("USER_ID",0);
        dbh=DatabaseHelper.getInstance(getApplicationContext());


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        asset_category.setAdapter(adapter);
        asset_category.setPrompt("Select A Bank Name");
        asset_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cat = asset_category.getSelectedItem().toString();
                //System.out.println(selected_bank);
                //name.setText(selected_bank);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //bank_name.setPrompt("Select A Bank Name");
            }
        });
//        assetName=asset_name.getText().toString();
//        assetValue=asset_value.getText().toString();
//        asset=new Asset(assetName,cat,Integer.parseInt(assetValue));

        //asset= new Asset(asset_name.getText(),cat,Integer.parseInt(asset_value.getText().toString()));


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                assetName=asset_name.getText().toString();
                assetValue=asset_value.getText().toString();
                asset=new Asset(assetName,cat,Integer.parseInt(assetValue));
//                Log.d("%%%%%%%%%%%",asset.toString());
                dbh.addAsset(userID,asset);
                ArrayList<Asset> assetArrayList= dbh.getAllAssets(userID);
                Intent intent=new Intent(AddAssetActivity.this, ShowAllAssetsActivity.class);
                intent.putExtra("LIST_OF_ASSETS",assetArrayList);
                intent.putExtra("USER_ID",userID);
                //hello
                startActivity(intent);

            }
        });


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_create_asset, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}

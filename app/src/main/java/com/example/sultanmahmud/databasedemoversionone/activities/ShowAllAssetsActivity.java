package com.example.sultanmahmud.databasedemoversionone.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.model.Asset;

import java.util.ArrayList;

public class ShowAllAssetsActivity extends AppCompatActivity {
    //TextView textView;
    Button addAssetButton;
    ListView assetsListView;
    ArrayList<Asset> assetArrayList;
    BaseAdapter baseAdapter;
    int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_assets);
        intializeAll();

    }

    void intializeAll(){
        addAssetButton=(Button)findViewById(R.id.asset_add_button);
        assetsListView=(ListView) findViewById(R.id.asset_list_view);
        assetArrayList=(ArrayList<Asset>)getIntent().getSerializableExtra("LIST_OF_ASSETS");
        userID=getIntent().getIntExtra("USER_ID",0);

        baseAdapter= new BaseAdapter() {
            LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            @Override
            public int getCount() {
                return assetArrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return assetArrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView==null){
                    convertView=inflater.inflate(R.layout.asset,null);

                }
                TextView assetnameTextView= (TextView) convertView.findViewById(R.id.asset_name_text_view);
                TextView assetcategoryTextView=(TextView)convertView.findViewById(R.id.asset_category_text_view);
                TextView assetvalueTextView=(TextView) convertView.findViewById(R.id.asset_value_text_view);
                assetnameTextView.setText(assetArrayList.get(position).getAssetName());
                assetcategoryTextView.setText(assetArrayList.get(position).getAssetCategory());
                assetvalueTextView.setText(""+assetArrayList.get(position).getAssetvalue());


                return convertView;
            }
        };

        assetsListView.setAdapter(baseAdapter);


        addAssetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ShowAllAssetsActivity.this,AddAssetActivity.class);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);

            }
        });


    }

}

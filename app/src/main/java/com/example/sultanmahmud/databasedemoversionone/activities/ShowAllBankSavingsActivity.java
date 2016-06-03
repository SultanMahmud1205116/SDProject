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
import com.example.sultanmahmud.databasedemoversionone.model.BankSavings;

import java.util.ArrayList;

public class ShowAllBankSavingsActivity extends AppCompatActivity {
    Button addBankSavingsButton;
    ListView bankSavingsListView;
    ArrayList<BankSavings> bankSavingsArrayList;
    BaseAdapter baseAdapter;
    int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_bank_savings);
        initializeall();


    }

    void initializeall(){
        addBankSavingsButton= (Button)findViewById(R.id.add_bank_savings_button);
        bankSavingsListView=(ListView) findViewById(R.id.bank_savings_list_view);
        bankSavingsArrayList=(ArrayList<BankSavings>)getIntent().getSerializableExtra("LIST_OF_BANK_SAVINGS");
        userID=getIntent().getIntExtra("USER_ID",0);
        baseAdapter= new BaseAdapter() {
            LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            @Override
            public int getCount() {
                return bankSavingsArrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return bankSavingsArrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView==null){
                    convertView=inflater.inflate(R.layout.bank_savings,null);

                }
                /*
                TextView assetnameTextView= (TextView) convertView.findViewById(R.id.asset_name_text_view);
                TextView assetcategoryTextView=(TextView)convertView.findViewById(R.id.asset_category_text_view);
                TextView assetvalueTextView=(TextView) convertView.findViewById(R.id.asset_value_text_view);
                assetnameTextView.setText(assetArrayList.get(position).getAssetName());
                assetcategoryTextView.setText(assetArrayList.get(position).getAssetCategory());
                assetvalueTextView.setText(""+assetArrayList.get(position).getAssetvalue());
                */

                TextView bankName= (TextView) convertView.findViewById(R.id.bank_name_text_view);
                TextView bankAccountNumber=(TextView)convertView.findViewById(R.id.account_number_text_view);
                TextView savings=(TextView)convertView.findViewById(R.id.savings_amount_text_view);
                TextView interest=(TextView)convertView.findViewById(R.id.interest_rate_text_view);
                TextView maturityDate=(TextView)convertView.findViewById(R.id.maturity_date_text_view);

                bankName.setText(bankSavingsArrayList.get(position).getBankName());
                bankAccountNumber.setText(bankSavingsArrayList.get(position).getBankAccount());
                savings.setText(""+bankSavingsArrayList.get(position).getSavingsAmount());
                interest.setText(""+bankSavingsArrayList.get(position).getInterestRate());
                maturityDate.setText(bankSavingsArrayList.get(position).getMaturity());



                return convertView;
                //return null;
            }
        };
        bankSavingsListView.setAdapter(baseAdapter);


        addBankSavingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ShowAllBankSavingsActivity.this, AddBankSavingsActivity.class);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);
            }
        });


    }
}

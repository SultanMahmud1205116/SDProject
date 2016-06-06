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
import com.example.sultanmahmud.databasedemoversionone.model.Income;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ShowAllIncomeActivity extends AppCompatActivity {
    Button addIncome;
    ListView incomeListView;
    ArrayList<Income>incomeArrayList;
    BaseAdapter baseAdapter;
    int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_income);
        initializeall();
    }

    void initializeall(){

        addIncome=(Button) findViewById(R.id.add_income_button_show_income);
        incomeListView=(ListView) findViewById(R.id.all_income_list_view_show_income);
        incomeArrayList=(ArrayList<Income>) getIntent().getSerializableExtra("INCOME_LIST");
        userID=getIntent().getIntExtra("USER_ID",0);
        baseAdapter= new BaseAdapter() {
            LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);

            @Override
            public int getCount() {
                return incomeArrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return incomeArrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView==null){
                    convertView=inflater.inflate(R.layout.income,null);
                }
                // start from here....
                TextView incomeDate=(TextView)convertView.findViewById(R.id.income_date_text_view_income);
                //TextView incomeSource=(TextView)convertView.findViewById(R.id.income_category_text_view_income);
                TextView incomeCategory=(TextView)convertView.findViewById(R.id.income_source_text_view_income);
                TextView incomeAmount=(TextView)convertView.findViewById(R.id.income_amount_text_view_income);
                TextView netTaxableIncome=(TextView) convertView.findViewById(R.id.net_taxable_income_text_view_income);
                TextView exemptedIncome=(TextView) convertView.findViewById(R.id.exempted_income_text_view_income);

                incomeDate.setText(incomeArrayList.get(position).getIncomeDate());
                //incomeSource.setText(incomeArrayList.get(position).getIncomeSource());
                incomeCategory.setText(incomeArrayList.get(position).getIncomeSource());
                incomeAmount.setText(""+incomeArrayList.get(position).getIncomeAmount());
                netTaxableIncome.setText(""+incomeArrayList.get(position).getNetTaxableAmount());
                exemptedIncome.setText(""+incomeArrayList.get(position).getExemptedAmount());



                return convertView;
            }

        };
        incomeListView.setAdapter(baseAdapter);


        addIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ShowAllIncomeActivity.this, AddIncomeActivity.class);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);
            }
        });


    }

}

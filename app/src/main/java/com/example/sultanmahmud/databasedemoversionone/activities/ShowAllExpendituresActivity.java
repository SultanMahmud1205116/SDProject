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
import com.example.sultanmahmud.databasedemoversionone.model.Expenditure;

import java.util.ArrayList;

public class ShowAllExpendituresActivity extends AppCompatActivity {

    Button addExpenditure;
    ListView expenditureListView;
    ArrayList<Expenditure> expenditureArrayList;
    BaseAdapter baseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_expenditures);
        initializeall();
    }

    void initializeall(){

        addExpenditure=(Button) findViewById(R.id.add_expenditure_button_expenditure);
        expenditureListView=(ListView) findViewById(R.id.expenditure_list_view_expenditure);
        expenditureArrayList=(ArrayList<Expenditure>) getIntent().getSerializableExtra("EXPENDITURE_LIST");


        baseAdapter= new BaseAdapter() {
            LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);

            @Override
            public int getCount() {
                return expenditureArrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return expenditureArrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //return null;
                if(convertView==null){
                    convertView=inflater.inflate(R.layout.expenditure,null);
                }
                TextView expenditureDate=(TextView) convertView.findViewById(R.id.expenditure_date_text_view_expenditure);
                TextView expenditureAmount=(TextView)convertView.findViewById(R.id.expenditure_amount_text_view_expenditure);
                TextView expenditureName=(TextView) convertView.findViewById(R.id.expenditure_name_text_view_expenditure);

                expenditureDate.setText(expenditureArrayList.get(position).getExpenditureDate());
                expenditureAmount.setText(""+expenditureArrayList.get(position).getExpenditureAmount());
                expenditureName.setText(expenditureArrayList.get(position).getExpenditureCategoryName());
                return convertView;
            }

        };
        expenditureListView.setAdapter(baseAdapter);


        addExpenditure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ShowAllExpendituresActivity.this, AddExpenditureActivity.class);
                startActivity(intent);

            }
        });

    }
}

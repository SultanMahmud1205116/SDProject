package com.example.sultanmahmud.databasedemoversionone.activities;

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
import com.example.sultanmahmud.databasedemoversionone.model.Savings;

import java.util.ArrayList;
import java.util.List;

public class ShowAllSavingsActivity extends AppCompatActivity {
    Button addSavingsButton;
    ListView savingsListView;
    ArrayList<Savings> savingsArrayList;
    BaseAdapter baseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_savings);
        intializeall();
    }

    void intializeall(){
        addSavingsButton= (Button) findViewById(R.id.add_savings_button_savings);
        savingsListView=(ListView)findViewById(R.id.savings_list_view_savings);
        savingsArrayList=(ArrayList<Savings>)getIntent().getSerializableExtra("SAVINGS_LIST");

        baseAdapter=new BaseAdapter() {
            LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);

            @Override
            public int getCount() {
                return savingsArrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return savingsArrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //return null;
                if(convertView==null){
                    convertView=inflater.inflate(R.layout.savings,null);
                }

                TextView savingsAmount= (TextView) findViewById(R.id.savings_amount_text_view_savings);
                TextView savingsDescription=(TextView) findViewById(R.id.savings_description_text_view_savings);
                TextView savingsCategory=(TextView) findViewById(R.id.savings_category_list_view_savings);
                savingsAmount.setText(""+savingsArrayList.get(position).getSavingsAmount());
                savingsDescription.setText(savingsArrayList.get(position).getSavingsDescription());
                savingsCategory.setText(savingsArrayList.get(position).getSavingsCategory());
                return convertView;
            }
        };
        savingsListView.setAdapter(baseAdapter);
    }
}

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
import com.example.sultanmahmud.databasedemoversionone.model.Loan;

import java.util.ArrayList;

public class ShowLoansGivenActivity extends AppCompatActivity {
    Button addLoansGiven;
    ListView loansGivenListView;
    BaseAdapter baseAdapter;
    ArrayList<Loan> loanArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_loans_given);

        initializeall();
    }
    void initializeall(){
        addLoansGiven= (Button) findViewById(R.id.add_loan_given_button_loan_given);
        loansGivenListView=(ListView) findViewById(R.id.loans_given_list_view_loan_given);
        loanArrayList=(ArrayList<Loan>)getIntent().getSerializableExtra("LOANS_GIVEN_LIST");
        //loanArrayList

        baseAdapter= new BaseAdapter() {
            LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);

            @Override
            public int getCount() {
                return loanArrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return loanArrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView==null){
                    convertView= inflater.inflate(R.layout.loans_given,null);
                }
                TextView loanGivenTo=(TextView) convertView.findViewById(R.id.loan_reciever_text_view_loan_given);
                TextView loanGivenDate=(TextView) convertView.findViewById(R.id.loan_given_date_text_view_loan_given);
                TextView loanAmount=(TextView) convertView.findViewById(R.id.loan_amount_text_view_loan_given);
                TextView loanGetBackDate=(TextView) convertView.findViewById(R.id.loan_get_back_text_view_loan_given);

                loanGivenTo.setText(loanArrayList.get(position).getLoanReciever());
                loanGivenDate.setText(loanArrayList.get(position).getDateGiven());
                loanAmount.setText(""+loanArrayList.get(position).getLoanAmount());
                loanGetBackDate.setText(loanArrayList.get(position).getDateToTake());



                return convertView;
            }
        };
        loansGivenListView.setAdapter(baseAdapter);

        addLoansGiven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ShowLoansGivenActivity.this, AddLoansGivenActivity.class);
                startActivity(intent);
            }
        });
    }
}

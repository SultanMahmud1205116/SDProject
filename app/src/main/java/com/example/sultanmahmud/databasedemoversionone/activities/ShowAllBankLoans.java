package com.example.sultanmahmud.databasedemoversionone.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.model.Borrow;
import com.example.sultanmahmud.databasedemoversionone.model.Loan;

import java.util.ArrayList;
import java.util.List;

public class ShowAllBankLoans extends AppCompatActivity {
    Button addBankLoanButton;
    ArrayList<Borrow> loanArrayList;
    ListView bankLoanListView;
    BaseAdapter baseAdapter;
    int userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_bank_loans);
        initializeall();
    }
    void initializeall(){
        addBankLoanButton=(Button) findViewById(R.id.add_bank_loan_button);
        bankLoanListView=(ListView) findViewById(R.id.bank_loan_list_view);
        loanArrayList= (ArrayList<Borrow>)getIntent().getSerializableExtra("BORROW_LIST");
        userID=getIntent().getIntExtra("USER_ID",0);
//        for (Borrow borrow: loanArrayList
//                ) {
//            Log.d("^^^^^^^",borrow.toString());
//
//
//        }
        baseAdapter=new BaseAdapter() {
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
                //return null;
                if(convertView==null){
                    convertView=inflater.inflate(R.layout.bank_loan,null);

                }
                TextView bankName=(TextView)convertView.findViewById(R.id.bank_name_text_view_bank_loan);
                TextView accountNumber=(TextView)convertView.findViewById(R.id.account_number_text_view_bank_loan);
                TextView paymentDate=(TextView)convertView.findViewById(R.id.payment_date_text_view_bank_loan);
                TextView deadline=(TextView)convertView.findViewById(R.id.deadline_text_view_bank_loan);
                TextView loanAmount=(TextView)convertView.findViewById(R.id.loan_amount_text_view_bank_loan);
                TextView interestRate=(TextView)convertView.findViewById(R.id.interest_rate_text_view_bank_loan);
                TextView paidAmount=(TextView)convertView.findViewById(R.id.paid_amount_text_view_bank_loan);
                bankName.setText(loanArrayList.get(position).getBankName());
                accountNumber.setText(loanArrayList.get(position).getBankAccount());
                paymentDate.setText(loanArrayList.get(position).getPaymentDate());
                deadline.setText(loanArrayList.get(position).getDeadlineDate());
                loanAmount.setText(""+loanArrayList.get(position).getLoanAmount());
                interestRate.setText(""+loanArrayList.get(position).getInterestRate());
                paidAmount.setText(""+loanArrayList.get(position).getPaidLoan());

                return  convertView;
            }

        };
        bankLoanListView.setAdapter(baseAdapter);


        addBankLoanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ShowAllBankLoans.this, AddBankLoansActivity.class);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);

            }
        });

    }
}

package com.example.sultanmahmud.databasedemoversionone.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.helper.DatabaseHelper;
import com.example.sultanmahmud.databasedemoversionone.model.Borrow;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class AddBankLoansActivity extends AppCompatActivity {

    String[] bank_list = {"Sonali Bank", "Rupali Bank", "Standard Chartered Bank", "Agrani Bank", "IFIC Bank","Islami Bank"};
    Spinner bank_name;
    String selected_bank, interest_rate, account_number, date, dead_date, paym_date, loan, paid;
    private DatePicker datePicker;
    private Calendar calendar;
    int year, month, day, y, m ,d;
    TextView in_rate, pay_date, dead, loan_am, paid_am, accnt;
    Button save;
    int userID,flag = 0;
    DatabaseHelper dbh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank_loans);
        dbh=DatabaseHelper.getInstance(getApplicationContext());
        bank_name = (Spinner) findViewById(R.id.bank_name);
        in_rate = (TextView) findViewById(R.id.interest);
        pay_date = (TextView) findViewById(R.id.payment_date);
        loan_am = (TextView) findViewById(R.id.loan);
        paid_am = (TextView) findViewById(R.id.paid);
        dead = (TextView) findViewById(R.id.deadline);
        accnt = (TextView) findViewById(R.id.accnt_number);
        userID=getIntent().getIntExtra("USER_ID",0);


        save = (Button) findViewById(R.id.save);

        //calender

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        //spinner

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bank_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        bank_name.setAdapter(adapter);
        bank_name.setPrompt("Select A Bank Name");
        bank_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_bank = bank_name.getSelectedItem().toString();
                //System.out.println(selected_bank);
                //name.setText(selected_bank);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //bank_name.setPrompt("Select A Bank Name");
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String bankAccount, float interestRate, double loanAmount, double paidLoan, double remainingLoan,
                //String paymentDate, String deadlineDate, String bankName
                interest_rate = in_rate.getText().toString();
                paym_date = pay_date.getText().toString();
                dead_date = dead.getText().toString();

                loan = loan_am.getText().toString();
                paid = paid_am.getText().toString();
                account_number = accnt.getText().toString();

                // float interestRate, double loanAmount, double paidLoan, double remainingLoan,  String paymentDate, String deadlineDate, String bankName
                Borrow borrow= new Borrow(Float.parseFloat(interest_rate),Double.parseDouble(loan),Double.parseDouble(paid),(Double.parseDouble(loan)-Double.parseDouble(paid)),paym_date,dead_date,selected_bank,account_number);
                dbh.addBankLoan(userID,borrow);
                ArrayList<Borrow> borrowArrayList = dbh.getBorrowList(userID);
                Intent intent= new Intent(AddBankLoansActivity.this, ShowAllBankLoans.class);
                //getBorrowArrayList
                intent.putExtra("BORROW_LIST",borrowArrayList);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);

            }
        });
    }

    public void saveAction(View view)
    {
//        interest_rate = in_rate.getText().toString();
//        paym_date = pay_date.getText().toString();
//        dead_date = dead.getText().toString();
//
//        loan = loan_am.getText().toString();
//        paid = paid_am.getText().toString();
//        account_number = accnt.getText().toString();
    }


    @SuppressWarnings("deprecation")
    public void setDeadline(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Calender", Toast.LENGTH_SHORT)
                .show();
        //dead.setText(date);
        flag = 0;
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Calender", Toast.LENGTH_SHORT)
                .show();
        flag = 1;
        //pay_date.setText(date);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            y = arg1;
            m = arg2+1;
            d = arg3;
            date = String.valueOf(d)+"-"+String.valueOf(m)+"-"+String.valueOf(y);
            if(flag == 1) pay_date.setText(date);
            else dead.setText(date);

            //showDate(arg1, arg2+1, arg3);
        }
    };



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_create_bank_loan, menu);
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

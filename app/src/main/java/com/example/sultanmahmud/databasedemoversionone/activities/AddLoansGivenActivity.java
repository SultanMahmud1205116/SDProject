package com.example.sultanmahmud.databasedemoversionone.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.helper.DatabaseHelper;
import com.example.sultanmahmud.databasedemoversionone.model.Loan;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AddLoansGivenActivity extends AppCompatActivity {

    TextView given, loan_amount, start_date, end_date;
    String givenTo, given_loan, date, start, end;
    Button s;
    private DatePicker datePicker;
    private Calendar calendar;
    int year, month, day, y, m ,d, flag = 0;
    DatabaseHelper dbh;
    int userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loans_given);
        dbh=DatabaseHelper.getInstance(getApplicationContext());
        given = (TextView)findViewById(R.id.given);
        loan_amount = (TextView)findViewById(R.id.amount);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        start_date = (TextView)findViewById(R.id.start);
        end_date  = (TextView) findViewById(R.id.end);
        s = (Button) findViewById(R.id.save);
        userID=getIntent().getIntExtra("USER_ID",0);


        //calender

//        calendar = Calendar.getInstance();
//        year = calendar.get(Calendar.YEAR);
//
//        month = calendar.get(Calendar.MONTH);
//        day = calendar.get(Calendar.DAY_OF_MONTH);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String dateGiven, double loanAmount, String dateToTake, String loanReciever
                //Log.d("&&&&&&&",given_loan);
                // Log.d("%%%%%%%",start);
                //Log.d("^^^^^^",end);
                //Log.d("&&&&&&",givenTo);
                givenTo = given.getText().toString();
                start = start_date.getText().toString();
                end = end_date.getText().toString();
                given_loan = loan_amount.getText().toString();
                double loanAmount=Double.parseDouble(given_loan);
                Log.d("&&&&&&&",given_loan);
                Log.d("%%%%%%%",start);
                Log.d("^^^^^^",end);
                Log.d("******",givenTo);
                Loan loan= new Loan(start,loanAmount,end,givenTo);
                dbh.addLoansGiven(userID,loan);
                ArrayList<Loan> allLoansGiven= dbh.getLoansGivenList(userID);
                Intent intent= new Intent(AddLoansGivenActivity.this, ShowLoansGivenActivity.class);
                intent.putExtra("LOANS_GIVEN_LIST", allLoansGiven);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);

            }
        });


    }

//    public void saveAction(View view)
//    {
//        givenTo = given.getText().toString();
//        start = start_date.getText().toString();
//        end = end_date.getText().toString();
//        given_loan = loan_amount.getText().toString();
//
//
//    }

    @SuppressWarnings("deprecation")
    public void setEndDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Calender", Toast.LENGTH_SHORT)
                .show();
        //dead.setText(date);
        flag = 0;
    }

    @SuppressWarnings("deprecation")
    public void setStartDate(View view) {
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
            if(flag == 1) start_date.setText(date);
            else end_date.setText(date);

            //showDate(arg1, arg2+1, arg3);
        }
    };


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_creat__loan_given, menu);
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

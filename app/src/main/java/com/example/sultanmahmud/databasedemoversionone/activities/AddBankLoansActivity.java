package com.example.sultanmahmud.databasedemoversionone.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sultanmahmud.databasedemoversionone.R;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.Calendar;


public class AddBankLoansActivity extends AppCompatActivity {

    String[] bank_list = {"Sonali Bank", "Jonota Bank", "Dutch Bangla", "Uttora Bank", "Exim Bank"};
    Spinner bank_name;
    String selected_bank, interest_rate, account_number, date, dead_date, paym_date, loan, paid;
    private DatePicker datePicker;
    private Calendar calendar;
    int year, month, day, y, m ,d;
    TextView in_rate, pay_date, dead, loan_am, paid_am, accnt;
    Button save;
    int flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank_loans);

        bank_name = (Spinner) findViewById(R.id.bank_name);
        in_rate = (TextView) findViewById(R.id.interest);
        pay_date = (TextView) findViewById(R.id.payment_date);
        loan_am = (TextView) findViewById(R.id.loan);
        paid_am = (TextView) findViewById(R.id.paid);
        dead = (TextView) findViewById(R.id.deadline);
        accnt = (TextView) findViewById(R.id.accnt_number);


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
    }

    public void saveAction(View view)
    {
        interest_rate = in_rate.getText().toString();
        paym_date = pay_date.getText().toString();
        dead_date = dead.getText().toString();

        loan = loan_am.getText().toString();
        paid = paid_am.getText().toString();
        account_number = accnt.getText().toString();
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
            date = String.valueOf(d)+"/"+String.valueOf(m)+"/"+String.valueOf(y);
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

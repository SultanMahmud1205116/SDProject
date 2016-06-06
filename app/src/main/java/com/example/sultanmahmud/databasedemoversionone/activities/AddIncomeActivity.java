package com.example.sultanmahmud.databasedemoversionone.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.helper.DatabaseHelper;
import com.example.sultanmahmud.databasedemoversionone.model.Income;

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

import java.util.ArrayList;
import java.util.Calendar;

public class AddIncomeActivity extends AppCompatActivity {

    Spinner income_src;
    TextView idate, amnt,  exmp;
    private DatePicker datePicker;
    private Calendar calendar;
    // import your list here
    String[] income_list = {"salary_basic_pay",
            "salary_special_pay",
            "salary_dearness_allowance",
            "salary_house_rent_allowance",
            "salary_medical_allowance",
            "salary_servant_allowance",
            "salary_leave_allowance",
            "salary_honorarium/reward/fee",
            "salary_overtime_allowance",
            "salary_bonus/ex_gratia",
            "salary_other_allowance",
            "salary_contribution_to_recognized_provident_fund",
            "salary_interest_accured_on_recognized_provident_fund",
            "salary_deemed_income_for_transport_facility",
            "salary_deemed_income_for_free_furnished/unfurnished_accomodation",
            "salary_others",
            "annual_rental_income",
            "agricultural_income",
            "business_income",
            "share_of_profit_in_a_firm",
            "income_of_spouse/minor_children",
            "capital_gains",
            "other_income",
            "foreign_income",
            "interest_on_securities",
            "hakooona_matata"};
    String selected_income, date, amount, exmpt_amount;
    int year, month, day, y, m ,d, userID;
    Button save;
    DatabaseHelper dbh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);
        userID=getIntent().getIntExtra("USER_ID",0);
        dbh=DatabaseHelper.getInstance(getApplicationContext());
        idate = (TextView)findViewById(R.id.date);
        amnt = (TextView)findViewById(R.id.amount);
        exmp = (TextView)findViewById(R.id.exmp_amount);
        save = (Button)findViewById(R.id.save);
        income_src = (Spinner)findViewById(R.id.income_source);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        //spinner

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, income_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        income_src.setAdapter(adapter);
        income_src.setPrompt("Select A Bank Name");
        income_src.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_income = income_src.getSelectedItem().toString();
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

                date = idate.getText().toString();
                amount = amnt.getText().toString();
                exmpt_amount = exmp.getText().toString();
                //String incomeDate, String incomeSource, double incomeAmount, double netTaxableAmount,
                //double exemptedAmount
                Income income= new Income(date,selected_income,Double.parseDouble(amount),(Double.parseDouble(amount)-Double.parseDouble(exmpt_amount)),Double.parseDouble(exmpt_amount));
                dbh.addIncome(userID,income);

                ArrayList<Income> incomeArrayList=dbh.getIncomeList(userID);
                Intent intent= new Intent(AddIncomeActivity.this, ShowAllIncomeActivity.class);
                intent.putExtra("INCOME_LIST",incomeArrayList);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);
            }
        });
    }

    public void saveAction(View view)
    {
//        date = idate.getText().toString();
//        amount = amnt.getText().toString();
//        exmpt_amount = exmp.getText().toString();
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Calender", Toast.LENGTH_SHORT)
                .show();
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
            String date = String.valueOf(d)+"/"+String.valueOf(m)+"/"+String.valueOf(y);
            idate.setText(date);
            //showDate(arg1, arg2+1, arg3);
        }
    };

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_create_income, menu);
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

package com.example.sultanmahmud.databasedemoversionone.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.helper.DatabaseHelper;
import com.example.sultanmahmud.databasedemoversionone.model.Expenditure;

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


public class AddExpenditureActivity extends AppCompatActivity {

    String[] cat_list = {"personal_and_fooding",
            "tax_paid_including_deduction_at_source_of_last_financial_year",
            "accomodation",
            "transport",
            "electric_bill_residence",
            "gas_bill_residence",
            "telephone_bill_residence",
            "education_children",
            "personal_expenses_foreign_travel",
            "festival_and_others",
            "others",
            "house_repair/collection",
            "municipal/local_tax",
            "wasa_bill_residence",
            "interest_on_loan/mortgage/capital_charge",
            "insurance_premimum",
            "vacancy_allowance",
            "others_for_house_property",
            "contribution_to_deferred_annuity",
            "contribution_to_provident_fund",
            "contribution_to_super_annuation_fund",
            "contribution_to_zakat_fund",
            "land_revenue"};
    Spinner exp_category;
    String selected_cat,  date, exp_amount;
    private DatePicker datePicker;
    private Calendar calendar;
    int year, month, day, y, m ,d;
    TextView exp_date, amount;
    Button saveButton;
    int userID;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenditure);
        dbh= DatabaseHelper.getInstance(getApplicationContext());
        userID=getIntent().getIntExtra("USER_ID",0);
        exp_date = (TextView)findViewById(R.id.date);
        amount = (TextView)findViewById(R.id.amount);
        exp_category = (Spinner)findViewById(R.id.cat);

        saveButton = (Button) findViewById(R.id.save_button);

        //calender

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        //spinner

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cat_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        exp_category.setAdapter(adapter);
        exp_category.setPrompt("Select A Bank Name");
        exp_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_cat = exp_category.getSelectedItem().toString();
                //System.out.println(selected_bank);
                //name.setText(selected_bank);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //bank_name.setPrompt("Select A Bank Name");
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*
                * b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {*/
                //String expenditureDate, double expenditureAmount, String expenditureCategoryName


                date = exp_date.getText().toString();
                exp_amount = amount.getText().toString();
//                Log.d("!!!!!!!!!",date);
//                Log.d("!!!!!!!!!",exp_amount);
//                Log.d("!!!!!!!!!",selected_cat);
                Expenditure expenditure= new Expenditure(date,Double.parseDouble(exp_amount),selected_cat);
                //Log.d("!!!!!!!!!",expenditure.toString());
                dbh.addExpenditure(userID,expenditure);
                ArrayList<Expenditure> expenditureArrayList=dbh.getExpenditureList(userID);
                Intent intent= new Intent(AddExpenditureActivity.this, ShowAllExpendituresActivity.class);
                intent.putExtra("EXPENDITURE_LIST", expenditureArrayList);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);
            }
        });


    }

//    public void saveAction(View view) {
//
////        date = exp_date.getText().toString();
////        exp_amount = amount.getText().toString();
//    }

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
            String date = String.valueOf(d)+"-"+String.valueOf(m)+"-"+String.valueOf(y);
            exp_date.setText(date);
            //showDate(arg1, arg2+1, arg3);
        }
    };


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_create__expenditure, menu);
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

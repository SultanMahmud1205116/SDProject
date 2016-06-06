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

public class AddSavingsActivity extends AppCompatActivity {

    Spinner cat_name;

    private DatePicker datePicker;
    private Calendar calendar;
    // import your list here
    String[] bank_list = {"Sonali Bank", "Jonota Bank", "Dutch Bangla", "Uttora Bank", "Exim Bank"};
    String amount, description, saveDate, selected_cat;
    int year, month, day, y, m ,d,userID;
    Button s;
    TextView amnt, save_date, save_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_savings);
        cat_name = (Spinner)findViewById(R.id.savings_category);
        amnt = (TextView)findViewById(R.id.amount);
        userID=getIntent().getIntExtra("USER_ID",0);
        save_date = (TextView)findViewById(R.id.date);
        save_des = (TextView)findViewById(R.id.des);
        s = (Button)findViewById(R.id.save);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        //spinner

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bank_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        cat_name.setAdapter(adapter);
        cat_name.setPrompt("Select A Bank Name");
        cat_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_cat = cat_name.getSelectedItem().toString();
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
        amount = amnt.getText().toString();
        description = save_des.getText().toString();
        saveDate = save_date.getText().toString();
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
            save_date.setText(date);
            //showDate(arg1, arg2+1, arg3);
        }
    };


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_create_savings, menu);
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

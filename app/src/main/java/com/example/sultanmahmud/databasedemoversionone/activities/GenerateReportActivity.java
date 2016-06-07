package com.example.sultanmahmud.databasedemoversionone.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.helper.DatabaseHelper;
import com.example.sultanmahmud.databasedemoversionone.model.AdminReport;

public class GenerateReportActivity extends AppCompatActivity {
    AdminReport adminReport;
    DatabaseHelper databaseHelper;
    //( avgTaxableIncomeOfAllUsers,  cityOfUserWithMaxIncome,  totalForeignIncomeOfAllUsers,  totalZakatAmountOfAllUsers)
    TextView avgTaxableIncomeOfAllUsersTextView;
    TextView cityOfUserWithMaxIncome;
    TextView totalForeignIncomeOfAllUsers;
    TextView totalZakatAmountOfAllUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_report);
        initializeall();

    }
    void initializeall(){
        avgTaxableIncomeOfAllUsersTextView=(TextView) findViewById(R.id.avgTaxableIncomeOfAllUsers_text_view);
        cityOfUserWithMaxIncome=(TextView)findViewById(R.id.cityOfUserWithMaxIncome_text_view);
        totalForeignIncomeOfAllUsers=(TextView)findViewById(R.id.totalForeignIncomeOfAllUsers_text_view);
        totalZakatAmountOfAllUsers=(TextView)findViewById(R.id.totalZakatAmountOfAllUsers_text_view);
        databaseHelper=DatabaseHelper.getInstance(getApplicationContext());

        adminReport=databaseHelper.getAdminReport();

        avgTaxableIncomeOfAllUsersTextView.setText(" Avg taxable Income :"+adminReport.getAvgTaxableIncomeOfAllUsers());
        cityOfUserWithMaxIncome.setText(" City of User with Maximum Income : "+adminReport.getCityOfUserWithMaxIncome());
        totalForeignIncomeOfAllUsers.setText("Total Foreign Income : "+adminReport.getTotalForeignIncomeOfAllUsers());
        totalZakatAmountOfAllUsers.setText("Total Zakat Amount : "+adminReport.getTotalZakatAmountOfAllUsers());


    }
}

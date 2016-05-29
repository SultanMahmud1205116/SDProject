package com.example.sultanmahmud.databasedemoversionone.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.model.TaxReport;

public class TaxResultShowActivity extends AppCompatActivity {

    TextView totalIncomeTextView;
    TextView exemptedExpenditureTextView;
    TextView totalTaxTestView;
    TaxReport taxReport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_result_show);
        initializeall();
    }
    void initializeall(){
        totalIncomeTextView=(TextView)findViewById(R.id.total_income_text_view);
        exemptedExpenditureTextView=(TextView)findViewById(R.id.exempted_expenditure_text_view);
        totalTaxTestView=(TextView)findViewById(R.id.total_tax_text_view);
        taxReport=(TaxReport)getIntent().getSerializableExtra("TAX_REPORT");
        totalIncomeTextView.setText("Total Income: "+taxReport.getTotalIncome());
        exemptedExpenditureTextView.setText("Exempted Expenditure: "+taxReport.getExemptedExpenditure());
        totalTaxTestView.setText("Total Tax: "+taxReport.getTotalTax());


    }
}

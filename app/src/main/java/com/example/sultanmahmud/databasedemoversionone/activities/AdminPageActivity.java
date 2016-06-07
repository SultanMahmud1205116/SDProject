package com.example.sultanmahmud.databasedemoversionone.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.helper.DatabaseHelper;
import com.example.sultanmahmud.databasedemoversionone.model.TaxCalculationParameter;

public class AdminPageActivity extends AppCompatActivity {
    Button generateReportButton;
    //Button editParameterButton;
    TaxCalculationParameter taxCalculationParameter;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        initializeall();
    }

    private void initializeall() {
        generateReportButton=(Button) findViewById(R.id.generate_report_button_admin_page_activity);
        //editParameterButton=(Button) findViewById(R.id.edit_parameters_button_admin_page_activity);
        databaseHelper=DatabaseHelper.getInstance(getApplicationContext());

        taxCalculationParameter=databaseHelper.getTaxCalculationParameter();

        generateReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminPageActivity.this, GenerateReportActivity.class);
                startActivity(intent);
            }

        });
        /*
        editParameterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPageActivity.this, EditTaxCalculationParametersActivity.class);
                intent.putExtra("TAX_CALCULATION_PARAMETERS",taxCalculationParameter);
                startActivity(intent);
            }
        });
        */
    }
}

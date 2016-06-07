package com.example.sultanmahmud.databasedemoversionone.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.model.TaxCalculationParameter;

public class EditTaxCalculationParametersActivity extends AppCompatActivity {
    TaxCalculationParameter taxCalculationParameter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tax_calculation_parameters);
        initilizeall();
    }

    private void initilizeall() {
        taxCalculationParameter=(TaxCalculationParameter) getIntent().getSerializableExtra("TAX_CALCULATION_PARAMETERS");
        Log.d("$$$$$$$",taxCalculationParameter.toString());
    }
}

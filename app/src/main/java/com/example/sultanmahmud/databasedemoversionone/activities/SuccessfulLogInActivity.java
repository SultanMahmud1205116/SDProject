package com.example.sultanmahmud.databasedemoversionone.activities;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.helper.DatabaseHelper;
import com.example.sultanmahmud.databasedemoversionone.model.Asset;
import com.example.sultanmahmud.databasedemoversionone.model.BankSavings;
import com.example.sultanmahmud.databasedemoversionone.model.Borrow;
import com.example.sultanmahmud.databasedemoversionone.model.Expenditure;
import com.example.sultanmahmud.databasedemoversionone.model.Income;
import com.example.sultanmahmud.databasedemoversionone.model.Loan;
import com.example.sultanmahmud.databasedemoversionone.model.Savings;
import com.example.sultanmahmud.databasedemoversionone.model.TaxReport;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SuccessfulLogInActivity extends AppCompatActivity  {

    Button taxCalculateButton;
    Button assetButton;
    Button bankLoanButton;
    Button bankSavingsButton;
    Button expendituresButton;
    Button incomeButton;
    Button loansGivenButton;
    //Button savingsButton;

    int userID=0;
    DatabaseHelper dbh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_log_in);



        intitializeAll();
        setClickListeners();
    }

    void intitializeAll(){
//        userName=(TextView) findViewById(R.id.user_name);
//        userPassword=(TextView) findViewById(R.id.user_password);
//        userName.setText("Hello with id: "+getIntent().getIntExtra("USER_ID",0));
//        //String s= getIntent().getStringExtra("USER_ID");
        userID=getIntent().getIntExtra("USER_ID",0);
        taxCalculateButton=(Button)findViewById(R.id.tax_calculation_button);
        assetButton=(Button)findViewById(R.id.asset_button);
        bankLoanButton=(Button)findViewById(R.id.bank_loan_successful_button);
        bankSavingsButton=(Button)findViewById(R.id.bank_savings_button);
        expendituresButton=(Button)findViewById(R.id.expenditure_button);
        incomeButton=(Button)findViewById(R.id.income_button);
        loansGivenButton=(Button)findViewById(R.id.loan_given_button);
        //savingsButton=(Button)findViewById(R.id.savings_button);
        dbh=DatabaseHelper.getInstance(getApplicationContext());



//        Log.d("This is the userId: ",s);
//        userPassword.setText("Hello World!!!!");
//          userName.setText(getIntent().getStringExtra("USER_NAME"));
//        //userPassword.setText(getIntent().getStringExtra("USER_PASSWORD"));
        
    }
    void setClickListeners(){


        assetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Asset> assetArrayList;

                assetArrayList= dbh.getAllAssets(userID);


//                for(Asset asset: assetArrayList){
//                    Log.d("################# ",asset.toString());
//                }


                Intent intent= new Intent(SuccessfulLogInActivity.this, ShowAllAssetsActivity.class);
                //int sizeOfArrayList=assetArrayList.size();
                intent.putExtra("LIST_OF_ASSETS",assetArrayList);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);



            }
        });


        bankSavingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<BankSavings> bankSavingsArrayList;
                bankSavingsArrayList=dbh.getAllBankSavings(userID);
                //Log.d("$$$$$$$$$$$",""+bankSavingsArrayList.size());

                Intent intent= new Intent(SuccessfulLogInActivity.this,ShowAllBankSavingsActivity.class);
                intent.putExtra("LIST_OF_BANK_SAVINGS",bankSavingsArrayList);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);
            }
        });

        taxCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaxReport taxReport = dbh.getTaxReport(userID);
                //ArrayList<TaxReport> taxReports= new ArrayList<TaxReport>();
                //taxReports.add(taxReport);
                Intent intent = new Intent(SuccessfulLogInActivity.this, TaxResultShowActivity.class);
                intent.putExtra("TAX_REPORT",taxReport);
                intent.putExtra("USER_ID",userID);
                //intent.put
                startActivity(intent);

            }
        });
        bankLoanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Borrow> borrowArrayList = dbh.getBorrowList(userID);
                Intent intent= new Intent(SuccessfulLogInActivity.this, ShowAllBankLoans.class);

                intent.putExtra("BORROW_LIST",borrowArrayList);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);

            }
        });
        loansGivenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Loan> loanArrayList=dbh.getLoansGivenList(userID);
                Intent intent= new Intent(SuccessfulLogInActivity.this,ShowLoansGivenActivity.class);
                intent.putExtra("LOANS_GIVEN_LIST",loanArrayList);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);
            }
        });
        incomeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Income> incomeArrayList=dbh.getIncomeList(userID);
                Intent intent= new Intent(SuccessfulLogInActivity.this, ShowAllIncomeActivity.class);
                intent.putExtra("INCOME_LIST",incomeArrayList);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);
            }
        });
        expendituresButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Expenditure> expenditureArrayList=dbh.getExpenditureList(userID);
                Intent intent= new Intent(SuccessfulLogInActivity.this, ShowAllExpendituresActivity.class);
                intent.putExtra("EXPENDITURE_LIST", expenditureArrayList);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);
            }
        });
        /*
        savingsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Savings> savingsArrayList=dbh.getSavingsList(userID);
                //Log.d("%%%%%", ""+savingsArrayList.size());
                Intent intent= new Intent(SuccessfulLogInActivity.this, ShowAllSavingsActivity.class);
                intent.putExtra("SAVINGS_LIST",savingsArrayList);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);
            }
        });
        */





    }

}

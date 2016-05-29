package com.example.sultanmahmud.databasedemoversionone.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sultanmahmud.databasedemoversionone.R;
import com.example.sultanmahmud.databasedemoversionone.helper.DatabaseHelper;
import com.example.sultanmahmud.databasedemoversionone.helper.UserHelper;
import com.example.sultanmahmud.databasedemoversionone.model.Asset;
import com.example.sultanmahmud.databasedemoversionone.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbh;
    EditText logInAsUserEmailEditText;
    EditText logInAsUserPasswordEditText;
    Button logInAsUserButton;

    Button signUpButton;

    EditText logInAsAdminNameEditText;
    EditText logInAsAdminPasswordEditText;
    Button logInAsAdminButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dbh = new DatabaseHelper(getApplicationContext());
        dbh=DatabaseHelper.getInstance(this);
        intitializeAll();
        // the commented lines are for showing all the users, these will be used for showing the assets later......
//
//        Log.d("Get All Users","We are getting  all users from main activity");
//
//        ArrayList<User> userArrayList= dbh.getUsersList();
//        for(User user: userArrayList){
//            Log.d("*****   User: ", user.toString());
//        }
//        dbh.closeDB();
    }


    void intitializeAll(){
        logInAsUserEmailEditText=(EditText) findViewById(R.id.log_in_as_user_email_edit_text);
        logInAsUserPasswordEditText=(EditText) findViewById(R.id.log_in_as_user_password_edit_text);
        logInAsUserButton= (Button)findViewById(R.id.log_in_as_user_button);

        signUpButton=(Button) findViewById(R.id.sign_up_button);


        logInAsAdminNameEditText=(EditText) findViewById(R.id.log_in_as_admin_name_edit_text);
        logInAsAdminPasswordEditText=(EditText)findViewById(R.id.log_in_as_admin_password_edit_text);
        logInAsAdminButton=(Button)findViewById(R.id.log_in_as_admin_button);


        logInAsUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmailOfUser=logInAsUserEmailEditText.getText().toString();
                String userPasswordOfUser=logInAsUserPasswordEditText.getText().toString();
                int userID=dbh.getUserId(userEmailOfUser,userPasswordOfUser);
                Intent intent;
//                Log.d("userName: ",userEmailOfUser);
//                Log.d("password: ",userPasswordOfUser);

                if(userID==-1){
                     intent= new Intent(MainActivity.this, UnsuccessfulLogInActivity.class);

                }
                else {


                     intent = new Intent(MainActivity.this, SuccessfulLogInActivity.class); // goes from the MainActivity to the SuccessfulLogInActivity
                     intent.putExtra("USER_ID",userID);
                     //intent.putExtra("DATABASE_HELPER",dbh);
                }

                // now to send information to that activity
                //intent.putExtra("USER_NAME",userNameOfUser);
                //intent.putExtra("USER_PASSWORD",userPasswordOfUser);
                // the first one was the tag of that information and the last one was the information


                startActivity(intent);// this is to start the intent, ie to start the SuccessfulLogInActivity

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(MainActivity.this, UnsuccessfulLogInActivity.class);
               // startActivity(intent);
                ArrayList<Asset> assetArrayList;

                assetArrayList= dbh.getAllAssets(1);


//                for(Asset asset: assetArrayList){
//                    Log.d("################# ",asset.toString());
//                }


                Intent intent= new Intent(MainActivity.this, ShowAllAssetsActivity.class);
                int sizeOfArrayList=assetArrayList.size();
                intent.putExtra("SIZE",sizeOfArrayList);
                startActivity(intent);
            }
        });


    }
}

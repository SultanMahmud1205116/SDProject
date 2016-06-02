package com.example.sultanmahmud.databasedemoversionone.activities;

import android.app.Application;

import com.example.sultanmahmud.databasedemoversionone.helper.DatabaseHelper;

/**
 * Created by sultanmahmud on 5/30/16.
 */
public class LoginPresenter {
    public LoginView view;
    public int userID;
    //public DatabaseHelper dbh=DatabaseHelper.getInstance(this);

    public LoginPresenter(LoginView view){
        this.view=view;
        this.userID=userID;
        // this has their loginservice worked up here,,, do not forget about that....
        //dbh=this.dbh;
    }

    public void onLoginClicked() {
        String userName=view.getUsername();
        if(userName.isEmpty()){
            view.showUsernameError("Error in username");
            return;
        }
        String password=view.getPassword();
        if(password.isEmpty()){
            view.showPasswordError("Error in password");
            return;
        }
        String adminName=view.getAdminName();
        if(adminName.isEmpty()){
            view.showAdminNameError("Error in admin name");
            return;
        }
        String adminPassword=view.getAdminPassword();
        if(adminPassword.isEmpty()){
            view.showAdminPasswordError("Error in admin password");
            return;
        }

        //String
//        int x;
//        try {
//            x = dbh.getUserId(userName, password);
//        }catch(NullPointerException e){
//            x=0;
//        }
//        if(x!=0){
//            view.startSuccessfulActivity();
//            return;
//        }


    }

}

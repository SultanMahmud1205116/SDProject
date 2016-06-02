package com.example.sultanmahmud.databasedemoversionone.activities;

/**
 * Created by sultanmahmud on 5/30/16.
 */
public interface LoginView {
    String getUsername();

    void showUsernameError(String s);

    String getPassword();

    void showPasswordError(String s);

   // void startSuccessfulActivity();
    String getAdminName();
    String getAdminPassword();
    void showAdminNameError(String s);
    void showAdminPasswordError(String s);
}

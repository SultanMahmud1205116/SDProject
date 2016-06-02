package com.example.sultanmahmud.databasedemoversionone.activities;

import com.example.sultanmahmud.databasedemoversionone.helper.DatabaseHelper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by sultanmahmud on 5/30/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock
    private LoginView view;

    @Mock
    private DatabaseHelper dbh;

    private LoginPresenter presenter;

    @Before
    public  void setUp() throws  Exception{
        presenter=new LoginPresenter(view);
    }

    @Test
    public void shouldShowErrorMessageWhenUserNameIsEmpty() throws Exception{
        when(view.getUsername()).thenReturn("");
        presenter.onLoginClicked();


        verify(view).showUsernameError("Error in username");
    }

    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception{
        when(view.getUsername()).thenReturn("James");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked();


        verify(view).showPasswordError("Error in password");
    }

    @Test
    public void shouldShowErrorWhenAdminNameIsEmpty() throws Exception{
        when(view.getUsername()).thenReturn("James");
        when(view.getPassword()).thenReturn("Bond");
        when(view.getAdminName()).thenReturn("");
        presenter.onLoginClicked();
        verify(view).showAdminNameError("Error in admin name");

    }

    @Test
    public  void shouldShowErrorWhenAdminPasswordIsEMpty() throws Exception{
        when(view.getUsername()).thenReturn("James");
        when(view.getPassword()).thenReturn("Bond");
        when(view.getAdminName()).thenReturn("Hello");
        when(view.getAdminPassword()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showAdminPasswordError("Error in admin password");

    }




}
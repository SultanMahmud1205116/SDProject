package com.example.sultanmahmud.databasedemoversionone.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sultanmahmud.databasedemoversionone.R;

public class DummyActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        intializeAll();

    }
    void intializeAll(){
        textView=(TextView) findViewById(R.id.textView3);
        textView.setText("ILY ");
    }
}

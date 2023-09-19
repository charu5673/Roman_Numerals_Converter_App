package com.example.roman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button dtr,rtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignbId(dtr,R.id.dtr);
        assignbId(rtd,R.id.rtd);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button)v;
        String text = button.getText().toString();
        if(text.equals("Roman numeral to Decimal"))
        {
            //activity main to rtd
            Intent i=new Intent(getApplicationContext(),dtr.class);
            startActivity(i);
            setContentView(R.layout.activity_dtr);
        }
        else
        {
            // activity main to dtr
            Intent i=new Intent(getApplicationContext(),rtd.class);
            startActivity(i);
            setContentView(R.layout.activity_rtd);
        }

    }
    void assignbId(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
}
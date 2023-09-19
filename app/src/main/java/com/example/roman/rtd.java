package com.example.roman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.*;

public class rtd extends AppCompatActivity implements View.OnClickListener{
    String rm="";
    int dc=0;
    TextView inscr,opscr;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bm,bc,be,rd,bb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtd);
        inscr=findViewById(R.id.inscr);
        opscr=findViewById(R.id.opscr);
        assignbId(b1,R.id.B1);
        assignbId(b2,R.id.B2);
        assignbId(b3,R.id.B3);
        assignbId(b4,R.id.B4);
        assignbId(b5,R.id.B5);
        assignbId(b6,R.id.B6);
        assignbId(b7,R.id.B7);
        assignbId(b8,R.id.B8);
        assignbId(b9,R.id.B9);
        assignbId(b0,R.id.B0);
        assignbId(bm,R.id.BMAd);
        assignbId(bc,R.id.BCLd);
        assignbId(be,R.id.BEd);
        assignbId(bb,R.id.BBd);
        assignbId(rd,R.id.RD);
    }
    void assignbId(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button)v;
        String text = button.getText().toString();
        if(text.equals("MAIN"))
        {
            //activity main to rtd
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            setContentView(R.layout.activity_main);
        }
        else if(text.equals("Clear"))
        {
            rm="";
            dc=0;
            inscr.setText("");
            opscr.setText("");
        }
        else if(text.equals("R->D"))
        {
            Intent i=new Intent(getApplicationContext(),dtr.class);
            startActivity(i);
            setContentView(R.layout.activity_dtr);
        }
        else {
            if(text.equals("BACK"))
            {
                if(dc!=0)
                {
                    dc=(dc-dc%10)/10;
                    inscr.setText(Integer.toString(dc));
                }
            }
            else if(text.equals("="))
            {
                if(dc!=0)
                {
                    rm=idk2(dc);
                    if(rm.equals("NO"))
                    {
                        opscr.setText("INVALID");
                    }
                    else {
                        opscr.setText(rm);
                    }
                }
            }
            else{
                dc=dc*10+(Integer.parseInt(text));
                inscr.setText(Integer.toString(dc));
            }
        }
    }

    public String idk2(int dc) {
        int tmp=0;
        if(dc>3999)
        return("NO");
        else
        {
            if(dc%1000!=dc)
            {
                tmp=dc-(dc%1000);
                while(tmp!=0)
                {
                    rm=rm+"M";
                    tmp-=1000;
                }
                dc=dc%1000;
            }
            if(dc%500!=dc)
            {
                if(dc>=900)
                {
                    rm=rm+"CM";
                    dc=dc%100;
                }
                else
                {
                    rm=rm+"D";
                    dc=dc%500;
                }
            }
            if(dc%100!=dc)
            {
                if(dc>=400)
                    rm=rm+"CD";
                else
                {
                    tmp=dc-(dc%100);
                    while(tmp!=0)
                    {
                        rm=rm+"C";
                        tmp-=100;
                    }
                }
                dc=dc%100;
            }
            if(dc%50!=dc)
            {
                if(dc>=90)
                {
                    rm=rm+"XC";
                    dc=dc%10;
                }
                else
                {
                    rm=rm+"L";
                    dc=dc%50;
                }
            }
            if(dc%10!=dc)
            {
                if(dc>=40)
                    rm=rm+"XL";
                else
                {
                    tmp=dc-(dc%10);
                    while(tmp!=0)
                    {
                        rm=rm+"X";
                        tmp-=10;
                    }
                }
                dc=dc%10;
            }
            if(dc%5!=dc)
            {
                if(dc>=9)
                {
                    rm=rm+"IX";
                    dc=dc%1;
                }
                else
                {
                    rm=rm+"V";
                    dc=dc%5;
                }
            }
            if(dc%1!=dc)
            {
                if(dc>=4)
                    rm=rm+"IV";
                else
                {
                    tmp=dc-(dc%1);
                    while(tmp!=0)
                    {
                        rm=rm+"I";
                        tmp-=1;
                    }
                }
                dc=dc%1;
            }
            return(rm);
        }
    }
}
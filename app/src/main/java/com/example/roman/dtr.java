package com.example.roman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.*;

public class dtr extends AppCompatActivity implements View.OnClickListener{
    TextView inscr;
    String rm="";
    int dc=0,n;
    TextView opscr;
    Button bi,bv,bx,bl,bc,bd,bm,bb,bcl,bma,dr,be;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtr);
        inscr=findViewById(R.id.inscr);
        opscr=findViewById(R.id.opscr);
        assignbId(bi,R.id.BI);
        assignbId(bv,R.id.BV);
        assignbId(bx,R.id.BX);
        assignbId(bl,R.id.BL);
        assignbId(bc,R.id.BC);
        assignbId(bd,R.id.BD);
        assignbId(bm,R.id.BM);
        assignbId(bb,R.id.BBr);
        assignbId(bcl,R.id.BCLr);
        assignbId(bma,R.id.BMAr);
        assignbId(be,R.id.BEr);
        assignbId(dr,R.id.DR);

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
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            setContentView(R.layout.activity_main);
        }
        else if(text.equals("Clear"))
        {
            inscr.setText("");
            opscr.setText("");
            rm="";
            dc=0;
        }
        else if(text.equals("D->R"))
        {
            Intent i=new Intent(getApplicationContext(),rtd.class);
            startActivity(i);
            setContentView(R.layout.activity_rtd);
        }
        else
        {
            if(text.equals("BACK"))
            {
                n=rm.length();
                if(n!=0)
                    rm=rm.substring(0,n-1);
                inscr.setText(rm);
            }
            else if(text.equals("=")) {
                if(rm.equals("")) {
                }
                else{
                    dc = idk1(rm);
                    if (dc == -1)
                        opscr.setText("INVALID");
                    else
                        opscr.setText(Integer.toString(dc));
                }
            }
            else {
                rm=rm+text;
                inscr.setText(rm);
            }
        }
    }

    public int idk1(String rm) {
        int x=7,y=3,z=8,q;
        dc=0;
        int i,n=rm.length();
        int a[]=new int[n];
        for(i=0;i<n;i++)
        {
            switch(rm.charAt(i))
            {
                case 'I':a[i]=1;break;
                case 'V':a[i]=5;break;
                case 'X':a[i]=10;break;
                case 'L':a[i]=50;break;
                case 'C':a[i]=100;break;
                case 'D':a[i]=500;break;
                case 'M':a[i]=1000;break;
            }
            q=z;
            z=y;
            y=x;
            x=a[i];
            if(y==z&&x==y&&q==z)
            {
                dc=-1;
                break;
            }
        }
        for(i=0;i<n-1;i++)
        {
            if(dc==-1)
                break;
            if(a[i]<a[i+1])
            {
                a[i+1]=a[i+1]-a[i];
                a[i]=0;
            }
        }
        for(i=0;i<n;i++)
        {
            if(dc==-1)
                break;
            dc+=a[i];
        }
        return(dc);
    }

}
package com.exadel.drcreeper.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends AppCompatActivity {
    public static double a = 0;
    public static double b = 0;
    public static Operators act = null;
    public static boolean state = false;
    TextView t = null;
    public double parseField(){
        double ans = 0;
        try {
            ans = Double.parseDouble(t.getText().toString());
        } catch (NumberFormatException e) {
            t.setText("0");
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }
        return ans;
    }
    public void writeFirstNum() {
        a = parseField();
    }
    public void numPress(String c) {
        if (state) {
            t.setText("0");
            state = false;
        }
        String text = t.getText().toString();
        if (text.equals("0") && !(c.equals(new String(".")))) {
            t.setText(c);
        } else {
            t.setText(text + c);
        }
    }
    public void show(double s){
        String str = Double.toString(s);
        if(str.endsWith(".0")){
            str = str.substring(0,str.length() - 2);
        }
        if(str.length()>16){
            str = str.substring(0,16);
        }
        t.setText(str);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.main_textView);
        t.setText("0");
        Button nums[] = {
                (Button)findViewById(R.id.button0),
                (Button)findViewById(R.id.button1),
                (Button)findViewById(R.id.button2),
                (Button)findViewById(R.id.button3),
                (Button)findViewById(R.id.button4),
                (Button)findViewById(R.id.button5),
                (Button)findViewById(R.id.button6),
                (Button)findViewById(R.id.button7),
                (Button)findViewById(R.id.button8),
                (Button)findViewById(R.id.button9),
                (Button)findViewById(R.id.button_point)
        };
        Button plus = (Button) findViewById(R.id.button_add);
        Button minus = (Button) findViewById(R.id.button_sub);
        Button mul = (Button) findViewById(R.id.button_mul);
        Button div = (Button) findViewById(R.id.button_div);
        Button calculate = (Button) findViewById(R.id.button_res);
        Button clear = (Button) findViewById(R.id.button_clear);
        Button erace = (Button) findViewById(R.id.erace);
        for(final Button num : nums){
            num.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v){
                    numPress((String)num.getText());
                }
            });
        }
        plus.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){

                writeFirstNum();
                act = Operators.PLUS;
                t.setText("0");
            }
        });
        minus.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){

                writeFirstNum();
                act = Operators.MINUS;
                t.setText("0");
            }
        });
        mul.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){

                writeFirstNum();
                act = Operators.MUL;
                t.setText("0");
            }
        });
        div.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){

                writeFirstNum();
                act = Operators.DIV;
                t.setText("0");
            }
        });
        calculate.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                if(!state){
                    b = parseField();
                }
                if(act!=null){
                    String ans = Double.toString(act.calculate(a,b));
                    if(ans.endsWith(".0")){
                        ans = ans.substring(0,ans.length() - 2);
                    }
                    if(ans.length()>16){
                        ans = ans.substring(0,16);
                    }
                    t.setText(ans);
                    a = Double.parseDouble(t.getText().toString());
                }
                state = true;
            }
        });
        clear.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                t.setText("0");
                state = false;
                a = 0;
                b = 0;
            }
        });
        erace.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                if(t.getText().length()>0){
                    t.setText(t.getText().toString().substring(0,t.getText().toString().length()-1));
                }
                if(t.getText().length()==0){
                    t.setText("0");
                }
            }
        });
    }
    }


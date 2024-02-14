package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resWin;
    private EditText firstNum, secondNum;
    private Button add, sub, mul, div;
    float a, b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNum = findViewById(R.id.a);
        secondNum = findViewById(R.id.b);
        resWin = findViewById(R.id.res);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
    }

    public void All_Click(View view)
    {
        String sa = firstNum.getText().toString();
        String sb = secondNum.getText().toString();

        //Float a = 0.0f, b = 0.0f;



        try
        {
            a = Float.parseFloat(sa);
            b = Float.parseFloat(sb);
        }
        catch(Exception e1)
        {
            resWin.setText("one or booth values are empty");
            return;
        }

        float r = 0.0f;

        if (view == add) r = a + b;
        if (view == sub) r = a - b;
        if (view == mul) r = a * b;
        if (view == div)
        {
            if (b > -0.00001f && b < 0.00001f)
            {
                resWin.setText("division by zero");
                return;
            }
            r = a / b;
        }
        resWin.setText(String.valueOf(r));


    }



}
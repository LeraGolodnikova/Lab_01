package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resWin;
    private EditText firstNum, secondNum;
    private Button add, sub, mul, div, sin, cos, tan, sqrt, pow;
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
        cos = findViewById(R.id.cos);
        sin = findViewById(R.id.sin);
        tan = findViewById(R.id.tan);
        sqrt = findViewById(R.id.sqrt);
        pow = findViewById(R.id.pow);
    }

    public void All_Click(View view)
    {
        String sa = firstNum.getText().toString();
        String sb = secondNum.getText().toString();
        Float r = 0.0f;

        if (view == add || view == sub || view == mul || view == div)
        {

            try
            {
                a = Float.parseFloat(sa);
                b = Float.parseFloat(sb);
            }
            catch(Exception e1)
            {
                resWin.setText("Оба поля для ввода должны быть заполнены");
                return;
            }
            if (view == add) r = a + b;
            if (view == sub) r = a - b;
            if (view == mul) r = a * b;
            if (view == div)
            {
                if (b > -0.00001f && b < 0.00001f)
                {
                    resWin.setText("делить на ноль нельзя");
                    return;
                }
                r = a / b;
            }
            resWin.setText(String.valueOf(r));
        }
        else if (view == sin || view == cos || view == tan || view == sqrt || view == pow)
        {
            if(TextUtils.isEmpty(sb))
            {
                if (TextUtils.isEmpty(sa))
                {
                    resWin.setText("Поле 'a:' должно быть заполнено");
                }
                else
                {
                    double dr = 0;
                    if(view == sin) dr = Math.sin(a);
                    if(view == cos) dr = Math.cos(a);
                    if(view == tan) dr = Math.tan(a);
                    if(view == sqrt) dr = Math.sqrt(a);
                    if(view == pow) dr = Math.pow(a, 2);
                    resWin.setText(String.valueOf(dr));
                }
            }
            else
            {
                resWin.setText("Число должно быть записано только в поле 'a:'");
            }
        }
    }
}
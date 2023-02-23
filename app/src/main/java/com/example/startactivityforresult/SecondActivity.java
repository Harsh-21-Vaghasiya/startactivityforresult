package com.example.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

setTitle("second");
        Intent intent=getIntent();
        final int number1=intent.getIntExtra("number1",0);
        final int number2=intent.getIntExtra("number2",0);

        TextView textViewNums=findViewById(R.id.textview2);
        textViewNums.setText("Numbers :"+number1+","+ number2);

        Button buttonsend=findViewById(R.id.sendresult);
        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result=number1+number2;
                Intent resultintent=new Intent();
                resultintent.putExtra("result",result);
                startActivity(resultintent);

                setResult(RESULT_OK,resultintent);
                finish();
            }
        });





    }
}
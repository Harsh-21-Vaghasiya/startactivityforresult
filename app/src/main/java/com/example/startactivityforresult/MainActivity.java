package com.example.startactivityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText number1;
    private EditText number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=findViewById(R.id.result);
        number1=findViewById(R.id.box1);
        number2=findViewById(R.id.box2);

        Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if (number1.getText().toString().equals("")||number2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Please enter number",Toast.LENGTH_SHORT).show();
                }
                else {
                    int num1=Integer.parseInt(number1.getText().toString());
                    int num2=Integer.parseInt(number2.getText().toString());

                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("number1",num1);
                    intent.putExtra("number2",num2);
                    startActivityForResult(intent,1);

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1)
        {
            if (resultCode==RESULT_OK)
            {
                int results=data.getIntExtra("result ",0);
                result.setText(""+results);
            }
            else {
                result.setText("nothing");
            }
        }
    }
}
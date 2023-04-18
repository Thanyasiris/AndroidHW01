package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.Logger;

public class SecondActivity extends AppCompatActivity {

    int operator = 0;
    int fst = 0;
    int sec = 0;
    double output=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        operator = getIntent().getIntExtra("operator",operator);
        //System.out.println("operator: "+operator);
        Log.d("operator","operator no."+operator);

        TextView outputTextView = findViewById(R.id.output);

        EditText editFirstInput = findViewById(R.id.firstInput);

        EditText editSecondInput = findViewById(R.id.secondInput);

        editFirstInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String first = editFirstInput.getText().toString();
                if(!first.isEmpty()){
                    fst = Integer.parseInt(first);
                }

                String second = editSecondInput.getText().toString();
                if(!second.isEmpty()){
                    sec = Integer.parseInt(second);
                }

                output = Cal(operator, fst, sec);
                outputTextView.setText(String.format("%.2f",output));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editSecondInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String first = editFirstInput.getText().toString();
                if(!first.isEmpty()){
                    fst = Integer.parseInt(first);
                }

                String second = editSecondInput.getText().toString();
                if(!second.isEmpty()){
                    sec = Integer.parseInt(second);
                }

                output = Cal(operator, fst, sec);
                outputTextView.setText(String.format("%.2f",output));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private double Cal(int opr,int fst,int sec){
        double out=0;
        switch (opr){
            case 0:
                out = fst + sec;
                break;
            case 1:
                out = fst - sec;
                break;
            case 2:
                out = fst * sec;
                break;
            case 3:
                if(sec == 0){
                    return 0;
                }
                out = ((double)fst) / sec;
        }
        return out;
    }

}
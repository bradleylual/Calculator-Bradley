package com.introtoandroid.calculator_bradley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView currentOperation;
    private Double savedNum = 0.0;
    private Double currentNum = 0.0;
    private boolean isInput = false;
    private String inputString= "";
    private String opString="";
    private String savedString= "";
    private String calcString= "";

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonC;
    private Button buttonCE;
    private Button buttonEquals;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMult;
    private Button buttonDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMult = (Button) findViewById(R.id.buttonMult);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonCE = (Button) findViewById(R.id.buttonCE);
        buttonEquals = (Button) findViewById(R.id.buttonEquals);
        currentOperation = (TextView) findViewById(R.id.operation);
        currentOperation.setText(savedString + opString + inputString);

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputString += "0";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputString += "1";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputString += "2";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputString += "3";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputString += "4";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputString += "5";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputString += "6";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputString += "7";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputString += "8";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputString += "9";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                savedString = inputString;
                opString = " + ";
                inputString = "";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                savedString = inputString;
                opString = " - ";
                inputString = "";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        buttonMult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                savedString = inputString;
                opString = " * ";
                inputString = "";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                savedString = inputString;
                opString = " / ";
                inputString = "";
                currentOperation.setText(savedString + opString + inputString);
            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!savedString.isEmpty() && !inputString.isEmpty())
                    System.out.println(savedString);
                    calculate();
            }
        });

        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString = "";
                savedString = "";
                opString = "";
                calcString = "";
                savedNum = 0.0;
                currentNum = 0.0;
                currentOperation.setText("");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputString == "") {
                    currentOperation.setText("");
                    savedString = "";
                    opString = "";
                }
                else {
                    inputString = "";
                    currentOperation.setText(savedString + opString + inputString);
                }

            }
        });
    }

        public void calculate() {
            savedNum = Double.valueOf(savedString);
            currentNum = Double.valueOf(inputString);

            if(opString.contains("+"))
                savedNum = savedNum + currentNum;
            else if(opString.contains("-"))
                savedNum = savedNum - currentNum;
            else if(opString.contains("*"))
                savedNum = savedNum * currentNum;
            else if(opString.contains("/"))
                savedNum = savedNum / currentNum;

            savedString = savedNum.toString();
            inputString = "";
            opString = "";
            savedNum = 0.0;
            currentNum = 0.0;
            currentOperation.setText(savedString);

        }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("inputString", inputString);
        outState.putString("savedString", savedString);
        outState.putString("opString", opString);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        inputString = savedInstanceState.getString("inputString");
        savedString = savedInstanceState.getString("savedString");
        opString = savedInstanceState.getString("opString");
        currentOperation.setText(savedString + opString + inputString);
    }

}

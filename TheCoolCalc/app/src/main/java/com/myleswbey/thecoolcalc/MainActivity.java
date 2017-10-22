package com.myleswbey.thecoolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {


   public enum Operation    {
       ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL

   }

    String runningNumber = "";

    String leftNum = "";

    String rightNum = "";

    TextView resultText;

    Operation currentOperation;

    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button one = (Button) findViewById(R.id.one);

        Button two = (Button) findViewById(R.id.two);

        Button three = (Button) findViewById(R.id.three);

        Button four = (Button) findViewById(R.id.four);

        Button five = (Button) findViewById(R.id.five);

        Button six = (Button) findViewById(R.id.six);

        Button seven = (Button) findViewById(R.id.seven);

        Button eight = (Button) findViewById(R.id.eight);

        Button nine = (Button) findViewById(R.id.nine);

        Button zero = (Button) findViewById(R.id.zero);

        ImageButton calcBTN = (ImageButton) findViewById(R.id.calcBTN);

        ImageButton divideBTN = (ImageButton) findViewById(R.id.divideBTN);

        ImageButton multiplyBTN = (ImageButton) findViewById(R.id.multiplyBTN);

        ImageButton subtractBTN = (ImageButton) findViewById(R.id.subtractBTN);

        ImageButton addBTN = (ImageButton) findViewById(R.id.addBTN);

        Button clearBTN = (Button) findViewById(R.id.clearBTN);

  resultText = (TextView) findViewById(R.id.resultsText);
        resultText.setText("");

        one.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                numberPressed(1);

            }


        });

        two.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                numberPressed(2);

            }


        });

        three.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numberPressed(3);
            }


        });

        four.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numberPressed(4);
            }


        });

        five.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numberPressed(5);
            }


        });

        six.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numberPressed(6);
            }


        });

        seven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numberPressed(7);
            }


        });

        eight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numberPressed(8);
            }


        });

        nine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numberPressed(9);
            }


        });

        zero.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numberPressed(0);
            }


        });

        addBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                processOperation(Operation.ADD);

            }


        });

        subtractBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                processOperation(Operation.SUBTRACT);

            }


        });

        multiplyBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                processOperation(Operation.MULTIPLY);

            }


        });

        divideBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                processOperation(Operation.DIVIDE);

            }


        });

        calcBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                processOperation(Operation.EQUAL);

            }


        });

        clearBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            leftNum = "";
                rightNum = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                resultText.setText("0");

            }


        });

    }


    void processOperation(Operation operation)  {
    if(currentOperation != null){
        if(runningNumber != ""){
            rightNum = runningNumber;

            runningNumber = "";

            switch(currentOperation)    {
                case ADD:
                    result = Integer.parseInt(leftNum) + Integer.parseInt(rightNum);
                    break;
                case MULTIPLY:
                    result = Integer.parseInt(leftNum) * Integer.parseInt(rightNum);
                    break;
                case DIVIDE:
                    result = Integer.parseInt(leftNum) / Integer.parseInt(rightNum);
                    break;
                case SUBTRACT:
                    result = Integer.parseInt(leftNum) - Integer.parseInt(rightNum);
                    break;

            }

            leftNum = String.valueOf(result);
            resultText.setText(leftNum);
        }


    }else {
        leftNum = runningNumber;
        runningNumber = "";

    }
        currentOperation = operation;
    }

    void numberPressed(int number)  {

runningNumber += String.valueOf(number);

        resultText.setText(runningNumber);



    }
}

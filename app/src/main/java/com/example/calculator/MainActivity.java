package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import static com.example.calculator.utils.AppUtils.showMessage;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonZero;
    Button buttonDot,buttonEqual,buttonClr,buttonAdd,buttonSub,buttonMul,buttonDiv;
    EditText ed1,ed2;
    int count = 0;
    String expression = "";
    String text = "";
    Double result = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        buttonZero = (Button)findViewById(R.id.buttonZero);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonMul = (Button)findViewById(R.id.buttonMul);
        buttonSub = (Button)findViewById(R.id.buttonSub);
        buttonDiv = (Button)findViewById(R.id.buttonDiv);
        buttonDot = (Button)findViewById(R.id.buttonDot);
        buttonEqual = (Button)findViewById(R.id.buttonEqual);
        buttonClr = (Button)findViewById(R.id.buttonClr);
        ed1 = (EditText)findViewById(R.id.editText1);
        ed2 = (EditText)findViewById(R.id.editText2);
    }

    public void addSeven(View view) {
        ed2.setText(ed2.getText()+"7");
    }

    public void addEight(View view) {
        ed2.setText(ed2.getText()+"8");
    }

    public void addNine(View view) {

        ed2.setText(ed2.getText()+"9");
    }

    public void addFour(View view)
    {
        ed2.setText(ed2.getText()+"4");
    }

    public void addFive(View view)
    {
        ed2.setText(ed2.getText()+"5");
    }

    public void addSix(View view) {
        ed2.setText(ed2.getText()+"6");
    }

    public void addOne(View view) {
        ed2.setText(ed2.getText()+"1");
    }

    public void addTwo(View view) {
        ed2.setText(ed2.getText() + "2");
    }

    public void addThree(View view) {
        ed2.setText(ed2.getText() + "3");
    }

    public void addDot(View view) {
          if(count == 0 && ed2.length() != 0){
              ed2.setText(ed2.getText() + ".");
              count ++;
          }

    }

    public void addZero(View view) {
        ed2.setText(ed2.getText() + "0");
    }

    public void add(View view) {
            operationClicked("+");

    }

    public void sub(View view) {
      operationClicked("-");
    }

    public void mul(View view) {
        operationClicked("*");
    }
    public void div(View view){
       operationClicked("/");
    }

    public void equal(View view) {
        if(ed2.length() != 0){
            text = ed2.getText().toString();
            expression = ed1.getText().toString() + text;
        }
        ed1.setText("");
        if(expression.length() == 0)
            expression = "0.0";
        DoubleEvaluator evaluator = new DoubleEvaluator();
        try{
            result = new ExtendedDoubleEvaluator().evaluate(expression);
            if(!evaluator.equals("0.0"))
                ed2.setText(result+"");
        }
        catch (Exception e){
            ed2.setText("Invalid Expression");
            ed1.setText("");
            expression = "";
            e.printStackTrace();
        }
    }

    public void clear(View view) {
            if(ed2.getText() == null && ed1.getText() == null){
                showMessage(view, R.string.error_message, 0);
            }
            else {
                ed1.setText("");
                ed2.setText("");
                count = 0;
                expression = "";
            }

    }

    public void singleDigitClear(View view) {
        try {
            text = ed2.getText().toString();
            if(text.length() > 0){
                if(text.endsWith("."))
                    count = 0;
                String newText = text.substring(0,text.length()-1);
                if(newText.equals("-")){
                    newText = " ";
                }
                ed2.setText(newText);
            }
        } catch (Exception ee) {
            showMessage(view, R.string.error_message, 0);
        }
    }
    private void operationClicked(String s) {
         if(ed2.length() != 0){
             String text = ed2.getText().toString();
             ed1.setText(text + s);
             ed2.setText("");
             count = 0;
         }
         else{
             String text =  ed1.getText().toString();
             if(text.length() > 0){
                 String newText = text.substring(0,text.length()-1) + s;
                 ed2.setText(newText);
             }
         }
    }
}
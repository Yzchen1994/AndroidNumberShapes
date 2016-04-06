package com.example.macbook.androidnumbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{
        int number;

        public boolean isSquare(){
            double squareRoot=Math.sqrt(number);
            if(squareRoot==Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }
        }

        public boolean isTriangular(){
            int x=1;
            int triangularNumber=1;
            while(triangularNumber<number){
                x++;
                triangularNumber+=x;
            }
            if(triangularNumber==number){
                return true;
            }else{
                return false;
            }
        }

    }

    private static boolean isParsable(String input){
        boolean parsable = true;
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            parsable = false;
        }
        return parsable;
    }

    public void testNumber(View view){
        EditText usersNumber=(EditText) findViewById(R.id.usersNumber);
        Number myNumber=new Number();

        String message="";
            if(isParsable(usersNumber.getText().toString())) {
                myNumber.number = Integer.parseInt(usersNumber.getText().toString());
                if(myNumber.isSquare()){
                    if(myNumber.isTriangular()){
                        message=myNumber.number+" is square and triangular.";
                    }else{
                        message=myNumber.number+" is square but not triangular.";
                    }
                }else{
                    if(myNumber.isTriangular()){
                        message=myNumber.number+" is triangular but not square.";
                    }else{
                        message=myNumber.number+" is neither square nor triangular.";
                    }
                }
            }else{
                message="Please enter a number.";

        }


        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

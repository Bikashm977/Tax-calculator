package com.example.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn_cal;
    TextView textView_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.salary_EditText);
        btn_cal = (Button) findViewById(R.id.btn_calculate);
        textView_res = (TextView) findViewById(R.id.result_TextView);

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double Salary = Double.parseDouble(editText.getText().toString());

                if (Salary >= 1.0 && Salary < 200000.0) {
                    Double tax = Tax_one(Salary);
                    textView_res.setText("Your tax amount is: " + tax);
                } else if (Salary >= 200000.0 && Salary < 350000.0) {
                    Double tax = Tax_two(Salary);
                    textView_res.setText("Your tax amount is: " + tax);

                } else if (Salary >= 350000.0) {
                    Double tax = Tax_three(Salary);
                    textView_res.setText("Your tax amount is: " + tax);
                }

            }
        });
    }

    public Double Tax_one(Double salary) {

        Double tax_paid = (1.0 / 100.0) * salary;
        Log.d("1", tax_paid.toString());
        return tax_paid;
    }

    public Double Tax_two(Double salary) {
        Double Tax_one = (1.0 / 100) * 200000.0;

        Double remaning_salary = salary - 200000.0;

        Double remaning_tax = (15.0 / 100.0) * remaning_salary;

        Double total_tax = Tax_one + remaning_tax;

        Log.d("2", total_tax.toString());

        return total_tax;
    }

    public Double Tax_three(Double salary) {
        Double Tax_one = (1.0 / 100.0) * 200000.0;

        Double next_tax = (15.0 / 100.0) * 150000.0;

        Double remaning_salary = salary - (150000.0 + 200000.0);

        Double remaning_tax = (25.0 / 100.0) * remaning_salary;

        Double total_tax = Tax_one + next_tax + remaning_tax;

        Log.d("3", total_tax.toString());

        return total_tax;
    }
}

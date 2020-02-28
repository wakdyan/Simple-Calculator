package com.wakdyan.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView mTextResult;
    private EditText mEditFirst, mEditSecond, mEditThird;
    private CheckBox mCheckFirst, mCheckSecond, mCheckThird;

    private int mFirstValue, mSecondValue, mThirdValue;

    enum Operation {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION,
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mTextResult = findViewById(R.id.text_result);
        mEditFirst = findViewById(R.id.edit_first);
        mEditSecond = findViewById(R.id.edit_second);
        mEditThird = findViewById(R.id.edit_third);
        mCheckFirst = findViewById(R.id.check_first);
        mCheckSecond = findViewById(R.id.check_second);
        mCheckThird = findViewById(R.id.check_third);
    }

    public void operation(View view) {
        if (mCheckFirst.isChecked()) {
            mFirstValue = Integer.valueOf(mEditFirst.getText().toString());
        }

        if (mCheckSecond.isChecked()) {
            mSecondValue = Integer.valueOf(mEditSecond.getText().toString());
        }

        if (mCheckThird.isChecked()) {
            mThirdValue = Integer.valueOf(mEditThird.getText().toString());
        }

        switch (view.getId()) {
            case R.id.button_addition:
                countValue(mFirstValue, mSecondValue, mThirdValue, Operation.ADDITION);
                mFirstValue = 0;
                mSecondValue = 0;
                mThirdValue = 0;
                break;
            case R.id.button_subtraction:
                countValue(mFirstValue, mSecondValue, mThirdValue, Operation.SUBTRACTION);
                mFirstValue = 0;
                mSecondValue = 0;
                mThirdValue = 0;
                break;
            case R.id.button_multiplication:
                countValue(mFirstValue, mSecondValue, mThirdValue, Operation.MULTIPLICATION);
                mFirstValue = 0;
                mSecondValue = 0;
                mThirdValue = 0;
                break;
            case R.id.button_division:
                countValue(mFirstValue, mSecondValue, mThirdValue, Operation.DIVISION);
                mFirstValue = 0;
                mSecondValue = 0;
                mThirdValue = 0;
                break;
        }
    }

    private void countValue(int firstValue, int secondValue, int thirdValue, Operation operation) {
        Integer[] tempValue = {firstValue, secondValue, thirdValue};
        List<Integer> intValue = new ArrayList<Integer>(Arrays.asList(tempValue));

        intValue.removeAll(Arrays.asList(Integer.valueOf(0)));
        tempValue = intValue.toArray(new Integer[intValue.size()]);

        int val = tempValue[0];

        for (int i = 1; i < tempValue.length; i++) {
            if (operation == Operation.ADDITION) {
                val += tempValue[i];
            } else if (operation == Operation.SUBTRACTION) {
                val -= tempValue[i];
            } else if (operation == Operation.MULTIPLICATION) {
                val *= tempValue[i];
            } else if (operation == Operation.DIVISION) {
                val /= tempValue[i];
            }
        }

        if (tempValue.length <= 1) {
            mTextResult.setText(R.string.error_result);
        } else {
            mTextResult.setText(String.valueOf(val));
        }

    }
}

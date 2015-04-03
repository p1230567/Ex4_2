package com.cyo.ex4_2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by USER on 2015/4/3.
 */
public class Cul_BMI extends Activity {
    private Button btn_sumbit, btn_clear, btn_back;
    private EditText et_hight, et_weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_bmi);
        findViews();
        enterInfo();
    }

    protected void findViews(){

        btn_sumbit = (Button)findViewById(R.id.btn_sumbit);
        btn_clear = (Button)findViewById(R.id.btn_clear);
        btn_back = (Button)findViewById(R.id.btn_back);
        et_hight = (EditText)findViewById(R.id.et_hight);
        et_weight = (EditText)findViewById(R.id.et_weight);

    }

    private void enterInfo(){
        
    }
    





}



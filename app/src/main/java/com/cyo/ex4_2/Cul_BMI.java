package com.cyo.ex4_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
//        處理事件
        enterInfo();
    }

    protected void findViews() {

        btn_sumbit = (Button) findViewById(R.id.btn_sumbit);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_back = (Button) findViewById(R.id.btn_back);
        et_hight = (EditText) findViewById(R.id.et_hight);
        et_weight = (EditText) findViewById(R.id.et_weight);

    }

    private void enterInfo() {
        btn_sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                存放BMI計算值
                Double BMI;
                try {
//                    Double存放輸入的文字
                    Double weight = Double.parseDouble(et_weight.getText().toString());
                    Double hight = Double.parseDouble(et_hight.getText().toString());
                    if (hight <= 0 || hight >= 3) {
                        throw new Exception();
                    } else if (weight <= 0 || weight >= 500) {
                        throw new Exception();
                    } else if (weight.toString().isEmpty() || hight.toString().isEmpty()) {
                        throw new Exception();
                    }
                    BMI = weight / (hight * hight);

                } catch (Exception e) {
                    Toast.makeText(Cul_BMI.this, "資料有誤", Toast.LENGTH_SHORT).show();
                    et_weight.setText("");
                    et_hight.setText("");
                    return;
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
//               將BMI包裝起來
                bundle.putDouble("BMI", BMI);
                intent.putExtras(bundle);
//                回傳正確號碼、intent
                setResult(RESULT_OK, intent);
                finish();
            }

        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_hight.setText("");
                et_weight.setText("");
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Cul_BMI.this.finish();
            }
        });
    }


}



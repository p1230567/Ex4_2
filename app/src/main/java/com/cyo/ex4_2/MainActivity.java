package com.cyo.ex4_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends Activity {
    private final int request = 0;
    private Button btn_cul, btn_exit;
    private TextView tv_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    protected void findViews() {

        btn_cul = (Button) findViewById(R.id.btn_cul);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_cul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Cul_BMI.class);
                startActivityForResult(intent, request);
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        回傳代碼不正確，不執行動作
        if (requestCode != request) {
            return;
        } else if (resultCode == RESULT_OK) {
//            從Bundle的data中取得資料
            Bundle bundle = data.getExtras();
            Double BMI = bundle.getDouble("BMI");
//            轉換格式
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            if (BMI < 18.5) {
                tv_result.setText("BMI值為:" + decimalFormat.format(BMI) + "\n" + "過瘦");
            } else if (BMI >= 24) {
                tv_result.setText("BMI值為:" + decimalFormat.format(BMI) + "\n" + "過重");
            } else {
                tv_result.setText("BMI值為:" + decimalFormat.format(BMI) + "\n" + "正常");
            }
        }
        else if (resultCode == RESULT_CANCELED)
                tv_result.setText("確定不使用看看嗎?");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

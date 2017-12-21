package com.lovesapplabs.percentageoffandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lovesapplabs.percentageoffandroid.R;

public class MainActivity extends AppCompatActivity {

    public EditText etPercentageAmount; //= findViewById(R.id.et_EnterPerctOff);
    public EditText etItemAmount ;// findViewById(R.id.et_EnterPrice);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);



        Button btnCalc = findViewById(R.id.btn_Calc);
        btnCalc.setOnClickListener(new View.OnClickListener() {

            TextView tvTotal = (TextView) findViewById(R.id.tv_Total);

            @Override
            public void onClick(View v) {
                etPercentageAmount = (EditText)findViewById(R.id.et_EnterPerctOff);
                etItemAmount = findViewById(R.id.et_EnterPrice);

                String sItemAmount = etItemAmount.getText().toString();
                String sPercentageAmount = etPercentageAmount.getText().toString();
                float iItemAmount = Float.parseFloat(sItemAmount);
                float iPercentageAmount = Float.parseFloat(sPercentageAmount);
                float dec = iPercentageAmount / 100;
                float total = iItemAmount - (dec * iItemAmount);

                tvTotal.setText( Float.toString(total));
            }
        });

        Button btnClr = findViewById(R.id.btn_Clr);
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPercentageAmount = (EditText)findViewById(R.id.et_EnterPerctOff);
                etItemAmount = findViewById(R.id.et_EnterPrice);
                etItemAmount.setText(" ");
                etPercentageAmount.setText(" ");
            }
        });

    }




    @Override
    protected void onResume() {
        super.onResume();


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

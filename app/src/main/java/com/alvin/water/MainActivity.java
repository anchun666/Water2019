package com.alvin.water;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText ed_month;
    private EditText ed_next;
    int monthNum;
    int nextNum;
    Button button;
    private Intent intent;
    String TAG = MainActivity.class.getSimpleName();
    private Switch sw;
    boolean isNext = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"OnCreate");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ed_month = findViewById(R.id.type);



//        ed_next = findViewById(R.id.next);
        intent = new Intent(this,ResultActivity.class);
        sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.type);
                text.setText(isNext ? getString(R.string.every_other_month) : getString(R.string.monthly));

            }
        });
        Spinner cities = findViewById(R.id.spinner);
        cities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,getResources().getStringArray(R.array.cities)[position]);
            }
        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {


        @Override
        public void onClick(DialogInterface dialog, int which) {
            ed_month.setText(" ");
            ed_next.setText(" ");

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");}

    public void fee (View view){
        String month = ed_month.getText().toString();
        String next = ed_next.getText().toString();
        double fee = 0;
        if(!TextUtils.isEmpty(month)){
            monthNum = Integer.valueOf(month);
            if(1<=monthNum&&monthNum<=10){
                fee = monthNum*7.35;
            }if(11<=monthNum&&monthNum<=30) {
                fee = monthNum * 9.45 - 21;
            }if(31<=monthNum&&monthNum<=50) {
                fee = monthNum * 11.55 - 84;
            }if(monthNum>=51){
                fee = monthNum *12.075-110.25;
            }

            //new AlertDialog.Builder(MainActivity.this)
                    //.setMessage("水費:"+ fee)
                    //.setTitle("計算結果")
                    //.setPositiveButton("OK",listener)
                    //.show();
            intent = new Intent(this,ResultActivity.class);
            intent.putExtra("FEE",fee);
            startActivity(intent);
            Log.d("ResultActivity","fee");









        }else if(TextUtils.isEmpty(month)&&!TextUtils.isEmpty(next)){
            nextNum = Integer.valueOf(next);
            if(1<=nextNum&&nextNum<=10){
                fee = nextNum*7.35;
            }if(11<=nextNum&&nextNum<=30) {
                fee = nextNum * 9.45 - 42;
            }if(31<=nextNum&&nextNum<=50) {
                fee = nextNum * 11.55 - 168;
            }if(nextNum>=51){
                fee = nextNum *12.075-220.5;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage(getString(R.string.fee)+ fee)
                    .setTitle(getString(R.string.answer))
                    .setPositiveButton(getString(R.string.ok),listener)
                    .show();
            intent = new Intent(this,ResultActivity.class);
            intent.putExtra(getString(R.string.extra_fee),fee);
            startActivity(intent);
            Log.d("ResultActivity","fee");
        }
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

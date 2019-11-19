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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText ed_month;
    private EditText ed_next;
    int monthNum;
    int nextNum;
    Button button;
    private Intent intent;
    String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ed_month = findViewById(R.id.month);
        ed_next = findViewById(R.id.next);
        intent = new Intent(this,ResultActivity.class);



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
            //new AlertDialog.Builder(MainActivity.this)
                    //.setMessage("水費:"+ fee)
                    //.setTitle("計算結果")
                    //.setPositiveButton("OK",listener)
                    //.show();
            intent = new Intent(this,ResultActivity.class);
            intent.putExtra("FEE",fee);
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

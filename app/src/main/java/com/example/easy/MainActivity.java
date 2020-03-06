package com.example.easy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  LoginInterface{
    private Button button,a1;
    private SharedPreferenceUtil sharedPreferenceUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EzDialogFragment ezDialogFragment=new EzDialogFragment();
                ezDialogFragment.show(getSupportFragmentManager(), "loginDialog");
            }
        });
        a1=findViewById(R.id.testa1);
        final String [] test={"111","222","333"};

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] dinner = {"腿庫","雞蛋糕","沙威瑪","澳美客","麵線","麵疙瘩"};
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("test")
                        .setItems(dinner, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(MainActivity.this, "u click is"+test[which], Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.create();
                builder.show();
            }
        });

    }

    @Override
    public void onLoginInputComplete(String name, String password) {
        if (name.isEmpty()){
            Toast.makeText(this, "is Empty", Toast.LENGTH_SHORT).show();
        }else {
            sharedPreferenceUtil.setString(getBaseContext(),name,"");
        }
    }
}

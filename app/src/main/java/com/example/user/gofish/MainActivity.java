package com.example.user.gofish;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn = (ImageButton) findViewById(R.id.start);
        btn.setOnClickListener(this);
        btn= (ImageButton) findViewById(R.id.rules);
        btn.setOnClickListener(this);
        btn= (ImageButton) findViewById(R.id.about);
        btn.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
                break;

            case R.id.rules:
                intent = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }
    }




}



package com.queen.finalspace.ui;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.queen.finalspace.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findseasonsButton) Button mFindSeasonButton;
    @BindView(R.id.findEditText) EditText mFindEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindSeasonButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == mFindSeasonButton) {
            String find = mFindEditText.getText().toString();
            Toast.makeText(MainActivity.this, "Watch Out!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, FindActivity.class);
            intent.putExtra("find", find);
            startActivity(intent);
        }
    }

}
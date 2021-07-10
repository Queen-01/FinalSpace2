package com.example.finalspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindActivity extends AppCompatActivity {
    @BindView(R.id.list) ListView mListView;
    private String[] Seasons = new String[]{
            "Season one", "Season two", "Season three"
    };
    private String[] Chapters = new String[] {
            "Chapter One", "Chapter Two", "Chapter Three"
    };
//    private String[] Scenes = new String[]{
//            "The Toro Regetta", "The Happy Place", "The Grand Surrender", "The Other Side", "The Notorious Mrs.Goodspeed",
//            "Arachnitects", "The First Times They Met", "The Remembered", "The Closer You Get", "The Lost Spy"
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String find = intent.getStringExtra("find");

        FindArrayAdapter adapter = new FindArrayAdapter(this, android.R.layout.simple_list_item_1, Seasons, Chapters);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seasons = ((TextView)view).getText().toString();
                Toast.makeText(FindActivity.this, seasons, Toast.LENGTH_LONG).show();
            }
        });
    }

}

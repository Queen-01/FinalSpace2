package com.example.finalspace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EpisodeActivity extends AppCompatActivity {
    private String[] Chapters = new String[] {
            "Chapter One", "Chapter Two", "Chapter Three", "Chapter Four", "Chapter Five",
            "Chapter Six", "Chapter Seven", "Chapter  Eight", "Chapter Nine", "Chapter Ten",
    };
    private String[] Scenes = new String[]{
            "The Toro Regetta", "The Happy Place", "The Grand Surrender", "The Other Side", "The Notorious Mrs.Goodspeed",
            "Arachnitects", "The First Times They Met", "The Remembered", "The Closer You Get", "The Lost Spy"
    };
    @BindView(R.id.listview) ListView mListView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode);
        ButterKnife.bind(this);

        FindArrayAdapter adapter = new FindArrayAdapter(this, android.R.layout.simple_list_item_1, Chapters, Scenes);
        mListView2.setAdapter(adapter);
        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chapters = ((TextView)view).getText().toString();
                Toast.makeText(EpisodeActivity.this, chapters, Toast.LENGTH_LONG).show();
            }
        });
    }
}
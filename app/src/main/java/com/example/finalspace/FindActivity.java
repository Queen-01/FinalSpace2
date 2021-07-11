package com.example.finalspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.finalspace.model.FinalSpaceSearchResponse;
import com.example.finalspace.service.FinalSpaceApi;
import com.example.finalspace.service.FinalSpaceClient;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Callback;

public class FindActivity extends AppCompatActivity {
    @BindView(R.id.list) ListView mListView;
    private String[] Seasons = new String[]{
            "Season one", "Season two", "Season three"
    };
    private String[] Chapters = new String[] {
            "Chapter One", "Chapter Two", "Chapter Three"
    };
    private String location;

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

        FinalSpaceApi client = FinalSpaceClient.getClient();
        Call<FinalSpaceSearchResponse> call = client.getFinalSpace(location, "Seasons");

        call.enqueue(new Callback<FinalSpaceSearchResponse>()){
            @Override
            public void onResponse(Call<FinalSpaceSearchResponse> call, Response<FinalSpaceSearchResponse> response){
                Seasons seasonsList = response.body().getType();
                String[] chapters = new String[chaptersList.size()];
                String[] episodes = new String[episodesList.size()];

                for (int i = 0; i<chapters.length; i++){
                    chapters[i] = chaptersList.get(i).get

                }
            }
        }
//        public void getSeasons() throws Exception{
//            Request request = new Request.Builder()
//                    .url("https://finalspaceapi.com/api/v0/")
//                    .build();
//            try (Response response = client.newCall(request).execute) {
//                if (!response.isSuccessful())throw new IOException(""+ response);
//                System.out.println(response.body().string());
//            }
//        }
    }

}

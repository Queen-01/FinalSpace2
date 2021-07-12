package com.example.finalspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalspace.adapter.FindSpaceListAdapter;
import com.example.finalspace.model.Episode;
import com.example.finalspace.service.FinalSpaceApi;
import com.example.finalspace.service.FinalSpaceClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FindActivity extends AppCompatActivity {
    @BindView(R.id.list) ListView mListView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    private FindSpaceListAdapter mAdapter;
    public List<Episode> episodes;
//ide
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String find = intent.getStringExtra("find");

//        FindArrayAdapter adapter = new FindArrayAdapter(this, android.R.layout.simple_list_item_1, Seasons, Chapters);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seasons = ((TextView) view).getText().toString();
                Toast.makeText(FindActivity.this, seasons, Toast.LENGTH_LONG).show();
            }
        });
        FinalSpaceApi client = FinalSpaceClient.getClient();
        Call<List<Episode>> call = client.getEpisode();
        call.enqueue(new Callback<List<Episode>>() {
            @Override
            public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {
                hideProgressBar();
                if (response.isSuccessful()){
                    List<Episode> episodesList = response.body().getEpisode();
                    String[] episodes = new String[episodesList.siza()];
                    String[] characters = new String[episodesList.size()];
                    for (int i = 0; i< episodes.length; i++){
                        episodes[i] = episodes.get(i).getCharacters();
                    }
                    for (int i = 0; i < characters.length; i++){
                        Episode episode = episodes.get(i).getAirDate();
                        characters[i] = character.getName;
                    }
                    ArrayAdapter adapter = new FindArrayAdapter(FindActivity.this, android.R.layout.simple_list_item_1, episodes,characters);
                    mListView.setAdapter(adapter);

                    showEpisodes();
                }else{
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<List<Episode>> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }
        });
    }
    private void showFailureMessage(){
        mErrorTextView.setText("Please check your internet connection");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage(){
    mErrorTextView.setText("Something went wrong. Please try again later");
    mErrorTextView.setVisibility(View.VISIBLE);
    }
    public void showEpisodes(){
    mListView.setVisibility(View.VISIBLE);
    }
    public void hideProgressBar(){
    mProgressBar.setVisibility(View.GONE);
    }
}
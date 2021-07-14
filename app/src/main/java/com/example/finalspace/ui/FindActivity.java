package com.example.finalspace.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.finalspace.adapter.FindSpaceListAdapter;
import com.example.finalspace.FindArrayAdapter;
import com.example.finalspace.R;
import com.example.finalspace.adapter.EpisodeListAdapter;
import com.example.finalspace.model.Episode;
import com.example.finalspace.service.FinalSpaceApi;
import com.example.finalspace.service.FinalSpaceClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView) ListView mRecyclerView;
    @BindView(R.id.textView) TextView mTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.errorTextView) TextView mErrorTextView;

    private EpisodeListAdapter mAdapter;
    public Response<List<Episode>> ListEpisodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String find = intent.getStringExtra("find");
//
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String seasons = ((TextView) view).getText().toString();
//                Toast.makeText(FindActivity.this, seasons, Toast.LENGTH_LONG).show();
//            }
//        });

        FinalSpaceApi apiService = FinalSpaceClient.getClient();
        Call<List<Episode>> call = apiService.getEpisode();
        call.enqueue(new Callback<List<Episode>>() {
            @Override
            public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    Log.e("Let us see","We got here response successful");
                    ListEpisodes = response;
                    mAdapter = new EpisodeListAdapter(FindActivity.this, ListEpisodes);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FindActivity.this);
                    mRecyclerView.setLayoutMode(0);
                    mRecyclerView.setHasTransientState(true);

                    showEpisodes();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<List<Episode>> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
                Log.d("Lets check it out", "Response = " + t.toString());
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
    mRecyclerView.setVisibility(View.VISIBLE);
    }
    public void hideProgressBar(){
    mProgressBar.setVisibility(View.GONE);
    }
}
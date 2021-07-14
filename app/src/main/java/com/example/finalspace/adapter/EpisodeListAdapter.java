package com.example.finalspace.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalspace.R;
import com.example.finalspace.model.Episode;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

public class EpisodeListAdapter extends RecyclerView.Adapter<EpisodeListAdapter.EpisodeViewHolder> {
    private Response<List<Episode>> episodeList;
    private Context mContext;

    public EpisodeListAdapter(Context context, Response<List<Episode>> response) {
        mContext = context;
        episodeList = response;
    }


    @Override
    public EpisodeListAdapter.EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_list, parent, false);
        EpisodeViewHolder viewHolder = new EpisodeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EpisodeListAdapter.EpisodeViewHolder holder, int position) {
        holder.bindAlbum(episodeList.body().get(position));
    }

    @Override
    public int getItemCount() {
        return episodeList.body().size();
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.episodeImageView) ImageView mEpisodeImageView;
        @BindView(R.id.episodeName ) TextView mEpisodeNameTextView;
        @BindView(R.id.somethingEpisode) TextView mWeWillSeeWhatTextView;
        @BindView(R.id.episode) TextView mCountTextView;

        private Context mContext;

        public EpisodeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindAlbum(Episode response) {
            mEpisodeNameTextView.setText( response.getName());
            mWeWillSeeWhatTextView.setText("Writer :" +response.getWriter());
            mCountTextView.setText("Director: " +response.getDirector());
            Picasso.get().load(response.getImgUrl()).into(mEpisodeImageView);
            Log.e("Let us see",response.getImgUrl());
        }
    }
}

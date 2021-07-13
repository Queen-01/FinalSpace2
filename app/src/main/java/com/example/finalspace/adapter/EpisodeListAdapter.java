package com.example.finalspace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalspace.R;
import com.example.finalspace.model.Episode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EpisodeListAdapter extends RecyclerView.Adapter<EpisodeListAdapter.EpisodeViewHolder> {
    private List<Episode> mEpisodes;
    private Context mContext;

    public EpisodeListAdapter(Context context, List<Episode> episodes){
        mContext = context;
        mEpisodes = episodes;
    }

    @Override
    public EpisodeListAdapter.EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_list,parent,false);
        EpisodeViewHolder viewHolder = new EpisodeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EpisodeListAdapter.EpisodeViewHolder holder, int position) {
        holder.bindEpisode(mEpisodes.get(position));
    }

    @Override
    public int getItemCount() {
        return mEpisodes.size();
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.spacerImageView) ImageView mSpacerImageView;
        @BindView(R.id.episodeNameTextView) TextView mEpisodeNameTextView;
        @BindView(R.id.characterTextView) TextView mCharacterTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;
        private Context mContext;

        public EpisodeViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
        public void bindEpisode(Episode episode){
            mEpisodeNameTextView.setText(episode.getName());
            mCharacterTextView.setText("Characters"+episode.getCharacters());
            mRatingTextView.setText("Rating" + episode.getDirector() + "/5");
        }
    }
}

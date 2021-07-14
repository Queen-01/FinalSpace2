package com.example.finalspace.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalspace.R;
import com.example.finalspace.model.Episode;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EpisodeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EpisodeDetailFragment extends Fragment {
    private static String episodesList;
    @BindView(R.id.episodeImageView) ImageView mImageView;
    @BindView(R.id.episodeName) TextView mEpisodeTextView;
    @BindView(R.id.episode) TextView mEpisodeLabelTextView;
    @BindView(R.id.like) TextView mLikeTextView;
    @BindView(R.id.unlike) TextView mUnlikeTextView;

//    private Episode episodesList;

    public EpisodeDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EpisodeDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EpisodeDetailFragment newInstance(String param1, String param2) {
        EpisodeDetailFragment episodeDetailFragment = new EpisodeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("episodes", Parcels.wrap(episodesList));
        episodeDetailFragment.setArguments(args);
        return episodeDetailFragment;
    }

    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
            episodesList = Parcels.unwrap(getArguments().getParcelable("episode"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_episode_detail,container,false);
        ButterKnife.bind(this, view);
//        Picasso.get().load(episodesList.getImgUrl()).into(mImageView);
        return inflater.inflate(R.layout.fragment_episode_detail, container, false);
    }
}
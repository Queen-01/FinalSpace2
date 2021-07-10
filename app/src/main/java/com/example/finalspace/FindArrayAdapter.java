package com.example.finalspace;

import android.content.Context;
import android.widget.ArrayAdapter;

public class FindArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mChapters;
    private String[] mScenes;

    public FindArrayAdapter(Context mContext, int resources, String[] mChapters, String[] mScenes){
        super(mContext, resources);
        this.mContext = mContext;
        this.mChapters = mChapters;
        this.mScenes = mScenes;

    }

    @Override
    public Object getItem(int position){
        String chapter = mChapters[position];
        String scene = mScenes[position];
        return String.format("%s \nServes great : %s", chapter, scene);
    }
    @Override
    public int getCount(){
        return mChapters.length;
    }

}

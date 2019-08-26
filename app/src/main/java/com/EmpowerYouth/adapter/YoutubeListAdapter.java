package com.EmpowerYouth.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.EmpowerYouth.Model;
import com.EmpowerYouth.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import com.EmpowerYouth.ListBlankFragment.OnFragmentInteractionListener;

public class YoutubeListAdapter extends RecyclerView.Adapter<YoutubeListAdapter.YoutubeListViewHolder> {

    private ArrayList<String> youtubeVidList= new ArrayList<>();
    private ArrayList<String> youtubeImgLink= new ArrayList<>();
    private ArrayList<String> youtubeVideoLinkList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;
    public OnFragmentInteractionListener listener;

    ArrayList<Model> videoLinkList;
    public YoutubeListAdapter(Context context,
                              ArrayList<Model> videoLinkList,
                              OnFragmentInteractionListener listener) {
        this.context = context;
        this.videoLinkList=videoLinkList;
        this.listener = listener;
        Log.d("hiiiiiiiiiiiiiiiii",Integer.valueOf(videoLinkList.size()).toString());
        for(int i=0;i<videoLinkList.size();i++){
            youtubeVidList.add(videoLinkList.get(i).getVideo_title());
            youtubeImgLink.add(videoLinkList.get(i).getImage_link());
            youtubeVideoLinkList.add(videoLinkList.get(i).getVideo_link());
        }
//
    }

    @NonNull
    @Override
    public YoutubeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_item, parent, false);
        return new YoutubeListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final YoutubeListViewHolder holder, final int position) {

        final String current = youtubeVidList.get(position);
        String imageLink = youtubeImgLink.get(position);
        Picasso.get().load(imageLink).into(holder.imageView);
        holder.title.setText(current);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClickListener(youtubeVideoLinkList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return youtubeVidList.size();
    }

    class YoutubeListViewHolder extends RecyclerView.ViewHolder{
        final TextView title;
        ImageView imageView;

        YoutubeListViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.youtube_link);
            imageView = itemView.findViewById(R.id.imageView2);

        }
    }
}

package com.EmpowerYouth.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.EmpowerYouth.Control;
import com.EmpowerYouth.Model;
import com.EmpowerYouth.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class YoutubeListAdapter extends RecyclerView.Adapter<YoutubeListAdapter.YoutubeListViewHolder> {

    private LinkedList<String> youtubeVidList= new LinkedList<>();
    private LayoutInflater layoutInflater;
    Control con=new Control();

    ArrayList<Model>    list=new ArrayList<>();
    public YoutubeListAdapter(Context context,
                              LinkedList<String> videoLinkList) {
        layoutInflater = LayoutInflater.from(context);
        //this.youtubeVidList = videoLinkList;
        for (int i = 0; i < 6; i++) {
            youtubeVidList.addLast("Word " + i);

        }
    }

    @NonNull
    @Override
    public YoutubeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.youtube_item, parent, false);
        return new YoutubeListViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeListViewHolder holder, int position) {
        String current = youtubeVidList.get(position);
        Log.d("YOUTUBE_LIST_ADAPTER", "here ");
//        if(current != null){
        for(String s : youtubeVidList){
            Log.d("YOUTUBE_LIST_ADAPTER", "dis "+ s);
        }

        holder.title.setText(current);
//        }
    }

    @Override
    public int getItemCount() {
        return youtubeVidList.size();
    }

    class YoutubeListViewHolder extends RecyclerView.ViewHolder{
        final TextView title;
        final YoutubeListAdapter adapter;

        YoutubeListViewHolder(View itemView, YoutubeListAdapter listAdapter){
            super(itemView);
            title = itemView.findViewById(R.id.youtube_link);
            adapter = listAdapter;
        }
    }
}

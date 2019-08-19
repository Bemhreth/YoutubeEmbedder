package com.EmpowerYouth;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.EmpowerYouth.adapter.YoutubeListAdapter;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Control {


    YoutubeConfig youtubeconfig = new YoutubeConfig();

    final Model model =new Model();
    ArrayList<Model> list=new ArrayList<>();

    public void setContext(Context context) {
        this.context = context;
    }

    Context context;
    public Context getContext() {
        return this.context;
    }



    public ArrayList<Model> maincontrol(final VolleyCallback callback) {
        // Toast.makeText(context,"the method is called",Toast.LENGTH_LONG).show();
        final ArrayList<Model>    li=new ArrayList<>();
        YoutubeConfig youtubeconfig = new YoutubeConfig();
        RequestQueue request1,request2;

        request1 = Volley.newRequestQueue(getContext());



        Log.d("heyyyyyyyyyyyyyyy","askldfjalks "+this.getContext());
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, youtubeconfig.API , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray object = new JSONObject(response).getJSONArray("items");

                    model.setViewed(object.getJSONObject(0).getJSONObject("statistics").getString("viewCount"));
                    Log.d("object things",object.getJSONObject(0).getJSONObject("statistics").getString("viewCount"));
                    model.setDislikes(object.getJSONObject(0).getJSONObject("statistics").getString("dislikeCount"));
                    model.setLikes(object.getJSONObject(0).getJSONObject("statistics").getString("likeCount"));


                    model.setTitle(object.getJSONObject(0).getJSONObject("snippet").getString("title"));

                    model.setDescription(object.getJSONObject(0).getJSONObject("snippet").getString("description"));
                    Toast.makeText(getContext(),model.getTitle(),Toast.LENGTH_LONG).show();



                    callback.onSuccess();

                } catch (JSONException e) {
                    Map<String, String> errorList = new HashMap<>();
                    errorList.put("message", "Error Parsing Response contact developer");
                    callback.onError(VolleyCallback.TYPE.JSON_ERROR,errorList);
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//
            }
        }) {




        };

        request1.add(stringRequest);

       // RecyclerView rv, YoutubeListAdapter yla
        Log.d("heyyyyyyyyyyyyyyy","askldfjalks "+this.getContext());
        request2 = Volley.newRequestQueue(this.getContext());
        Log.d("heyyyyyyyyyyyyyyy","askldfjalks "+request2);
        StringRequest stringRequest2 = new StringRequest(StringRequest.Method.GET, youtubeconfig.API1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONArray object = new JSONObject(response).getJSONArray("items");
                    for(int i=0 ;i<object.length();i++) {

                        model.setVideo_title(object.getJSONObject(i).getJSONObject("snippet").getString("title"));

                        model.setImage_link(object.getJSONObject(i).getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").getString("url"));

                        Log.d("this_is_unuque_because:" ,"-->"+model.getVideo_title());
                        list.add(model);
                    }


                    Toast.makeText(context, model.getTitle(), Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    Map<String, String> errorList = new HashMap<>();
                    errorList.put("message", "Error Parsing Response contact developer");

                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//
            }
        }) {




        };

        request2.add(stringRequest2);


//        ListBlankFragment fragment1 = new ListBlankFragment();
//        fragment1.setList1(list);
//        Log.d("heyyyyyyyyyyyyyyy","askldfjalks "+this.getContext());
        return list;
}

}


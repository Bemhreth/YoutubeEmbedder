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


//    YoutubeConfig youtubeconfig = new YoutubeConfig();
//
//    final Model model =new Model();
    ArrayList<Model> list=new ArrayList<>();

    public void setContext(Context context) {
        this.context = context;
    }

    Context context;
    public Context getContext() {
        return this.context;
    }


    ImageView i1;
    ImageView i2;
     TextView t1;
     TextView t2;
     TextView t3;

    public ImageView getI1() {
        return i1;
    }

    public void setI1(ImageView i1) {
        this.i1 = i1;
    }

    public ImageView getI2() {
        return i2;
    }

    public void setI2(ImageView i2) {
        this.i2 = i2;
    }

    public TextView getT1() {
        return t1;
    }

    public void setT1(TextView t1) {
        this.t1 = t1;
    }

    public TextView getT2() {
        return t2;
    }

    public void setT2(TextView t2) {
        this.t2 = t2;
    }

    public TextView getT3() {
        return t3;
    }

    public void setT3(TextView t3) {
        this.t3 = t3;
    }

    public TextView getT4() {
        return t4;
    }

    public void setT4(TextView t4) {
        this.t4 = t4;
    }

    TextView t4;

    public ArrayList<Model> maincontrol() {
        // Toast.makeText(context,"the method is called",Toast.LENGTH_LONG).show();
        final ArrayList<Model>    li=new ArrayList<>();
        YoutubeConfig youtubeconfig = new YoutubeConfig();
        RequestQueue request1,request2;
        final Model model =new Model();
        request1 = Volley.newRequestQueue(getContext());


//        Toast.makeText(getContext(), (CharSequence) getContext(),Toast.LENGTH_LONG).show();
        Log.d("heyyyyyyyyyyyyyyy","askldfjalks "+this.getContext());
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, youtubeconfig.API , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray object = new JSONObject(response).getJSONArray("items");
                    //Toast.makeText(context,object.toString(),Toast.LENGTH_LONG).show();
                    // Log.d("object things",object.toString());

                    //JSONObject organizationDetail = new JSONObject(response).getJSONObject("statistics");

                    model.setViewed(object.getJSONObject(0).getJSONObject("statistics").getString("viewCount"));
                    Log.d("object things",object.getJSONObject(0).getJSONObject("statistics").getString("viewCount"));
                    model.setDislikes(object.getJSONObject(0).getJSONObject("statistics").getString("dislikeCount"));
                    model.setLikes(object.getJSONObject(0).getJSONObject("statistics").getString("likeCount"));


                    model.setTitle(object.getJSONObject(0).getJSONObject("snippet").getString("title"));

                    model.setDescription(object.getJSONObject(0).getJSONObject("snippet").getString("description"));
                    Toast.makeText(getContext(),model.getTitle(),Toast.LENGTH_LONG).show();

                    //li.add(Model);
                    getT1().setText(model.getViewed());
                    Log.d("this_is_unuque_because:" ,"-->"+model.getLikes());
                    getT2().setText(model.getLikes());
                    Log.d("this_is_unuque_because:" ,"-->"+model.getDislikes());
                    getT3().setText(model.getDislikes());
                    Log.d("this_is_unuque_because:" ,"-->"+model.getTitle());
                    getT4().setText(model.getTitle());
                    Log.d("this_is_unuque_because:" ,"-->"+model.getDescription());

                } catch (JSONException e) {
                    Map<String, String> errorList = new HashMap<>();
                    errorList.put("message", "Error Parsing Response contact developer");

                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                if (error.networkResponse.statusCode == 404 || error.networkResponse.statusCode == 422) {
//                    Map<String, String> errorList = new HashMap<>();
//                    errorList.put("message", "No result found");
//
//                } else {
//                    Map<String, String> errorList = new HashMap<>();
//                    errorList.put("message", "Network error please check your internet connection");
//
//                }
//                Log.d("hhhh", error.getMessage());
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
                   // Log.d("this_is_unuque_because1:" ,"-->"+model.getVideo_title());
                    //li.add(Model);
//                t1.setText(model.getViewed());
//                Log.d("this_is_unuque_because:" ,"-->"+model.getLikes());
//                t2.setText(model.getLikes());
//                Log.d("this_is_unuque_because:" ,"-->"+model.getDislikes());
//                t3.setText(model.getDislikes());
//                Log.d("this_is_unuque_because:" ,"-->"+model.getTitle());
//                t4.setText(model.getTitle());
//                Log.d("this_is_unuque_because:" ,"-->"+model.getDescription());

                } catch (JSONException e) {
                    Map<String, String> errorList = new HashMap<>();
                    errorList.put("message", "Error Parsing Response contact developer");

                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                if (error.networkResponse.statusCode == 404 || error.networkResponse.statusCode == 422) {
//                    Map<String, String> errorList = new HashMap<>();
//                    errorList.put("message", "No result found");
//
//                } else {
//                    Map<String, String> errorList = new HashMap<>();
//                    errorList.put("message", "Network error please check your internet connection");
//
//                }
//                Log.d("hhhh", error.getMessage());
            }
        }) {




        };

        request2.add(stringRequest2);



        //Log.d("heyyyyyyyyyyyyyyy","askldfjalks "+this.getContext());
        return list;
}

}


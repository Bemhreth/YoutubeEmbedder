package com.EmpowerYouth;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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





    public void maincontrol(ImageView i1, ImageView i2, final TextView t1, final TextView t2, final TextView t3, final TextView t4, final Context context) {
        // Toast.makeText(context,"the method is called",Toast.LENGTH_LONG).show();
        final ArrayList<Model>    li=new ArrayList<>();
        YoutubeConfig youtubeconfig = new YoutubeConfig();
        RequestQueue request1;
        final Model model =new Model();
        request1 = Volley.newRequestQueue(context);
//        Toast.makeText(getContext(), (CharSequence) getContext(),Toast.LENGTH_LONG).show();

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
                    Toast.makeText(context,model.getTitle(),Toast.LENGTH_LONG).show();

                    //li.add(Model);
                    t1.setText(model.getViewed());
                    Log.d("this_is_unuque_because:" ,"-->"+model.getLikes());
                    t2.setText(model.getLikes());
                    Log.d("this_is_unuque_because:" ,"-->"+model.getDislikes());
                    t3.setText(model.getDislikes());
                    Log.d("this_is_unuque_because:" ,"-->"+model.getTitle());
                t4.setText(model.getTitle());
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



    }

}


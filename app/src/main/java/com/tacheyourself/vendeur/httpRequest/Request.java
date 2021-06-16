package com.tacheyourself.vendeur.httpRequest;
/*
 **    *** MainActivity ***
 **   Created by EL KHARROUBI HASSAN
 **   At Tuesday June 2021 23H 48MIN
 */


import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Request {

    public static final String TAG="Reuqest";

    private Context mContext;

    public Request(Context context) {
        mContext=context;

    }

    public void signIn(String email,String password){

        RequestQueue queue = Volley.newRequestQueue(mContext);
        String url="https://achrafzine.000webhostapp.com/MySmartHouse/read.php?User="+email+"&Password="+password;

        Log.d(TAG,"we are inside signIn");

        StringRequest request=new StringRequest(com.android.volley.Request.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //Traitment de reponse

                Log.d(TAG,response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d(TAG,error.getMessage());


            }
        });

        queue.add(request);


    }



}

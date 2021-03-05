package com.codepath.apps.restclienttemplate.models;

import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tweet {
    public String body;
    public String createdAt;
    public long id;
    public String imageType;
    public String previewUrl;
    public User user;
    public JSONObject entities;
    public JSONArray media;
    public JSONObject urls;

    public static final String TAG = "Tweet.java";

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.id = jsonObject.getLong("id");
        if (jsonObject.has("extended_entities")){
            tweet.entities = jsonObject.getJSONObject("extended_entities");
            if (tweet.entities.has("media")) {
                tweet.media = tweet.entities.getJSONArray("media");
                tweet.previewUrl = tweet.media.getJSONObject(0).getString("media_url_https");
                Log.d(TAG, tweet.body + "has a media url:  " + tweet.previewUrl);
            }
        }


        //tweet.imageType = jsonObject.getString("type");
        //tweet.previewUrl = jsonObject.getString("preview_image_url");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i <jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }
}

package com.codepath.apps.restclienttemplate.models;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//@Entity(foreignKeys = @ForeignKey(entity=User.class, parentColumns = "id", childColumns = "screenName"))
public class Tweet {

    public User user;
    public JSONObject entities;
    public JSONArray media;

    //@ColumnInfo
    //@PrimaryKey(autoGenerate = true)
    public long id;

    //@ColumnInfo
    public String body;
    //@ColumnInfo
    public String createdAt;
    //@ColumnInfo
    public String previewUrl;


    //@ColumnInfo
    public String screenName;

    public String imageType;



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
            else{tweet.previewUrl = null;}
        }
        else{tweet.previewUrl = null;}


        //tweet.imageType = jsonObject.getString("type");
        //tweet.previewUrl = jsonObject.getString("preview_image_url");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.screenName = tweet.user.screenName;
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

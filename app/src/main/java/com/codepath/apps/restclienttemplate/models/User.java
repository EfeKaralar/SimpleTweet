package com.codepath.apps.restclienttemplate.models;

import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


import org.json.JSONException;
import org.json.JSONObject;

//@Entity
public class User {
    public String screenName;
    public String name;
    public String profileImageUrl;

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.screenName = jsonObject.getString("screen_name");
        user.profileImageUrl = jsonObject.getString("profile_image_url_https");
        return user;
    }
}

/*package com.codepath.apps.restclienttemplate.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface TweetDao {

    @Query("SELECT * FROM Tweet where id := :id")
    public Tweet getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Long insertTweet(Tweet tweet);

    @Delete
    public void deleteTweet(Tweet tweet);
}
*/
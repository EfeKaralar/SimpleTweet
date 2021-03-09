package com.codepath.apps.restclienttemplate.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TweetDao {
    @Query("SELECT Tweet.body AS tweet_body, Tweet.createdAt AS tweet_createdAt, Tweet.id AS tweet_id, User.* " +
            "FROM Tweet INNER JOIN User ON Tweet.userId = User.id ORDER BY Tweet.createdAt DESC LIMIT 5")
    List<TweetWithUser> recentItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModel(User... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModel(Tweet... tweets);

    /*@Query("SELECT * FROM Tweet where id := :id")
    public Tweet getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Long insertTweet(Tweet tweet);

    @Delete
    public void deleteTweet(Tweet tweet);
     */
}

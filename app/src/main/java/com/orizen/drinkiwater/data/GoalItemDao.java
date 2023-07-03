package com.orizen.drinkiwater.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.orizen.drinkiwater.data.entities.GoalItem;
import java.util.List;

@Dao
public interface GoalItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertGoal(GoalItem goal);

    @Delete
    public void deleteGoal(GoalItem goal);

    @Update
    public void updateGoal(GoalItem goal);

    @Query("SELECT * FROM goal_items WHERE UserId =:userId")
    LiveData<List<GoalItem>> getGoalsById(Integer userId);
}

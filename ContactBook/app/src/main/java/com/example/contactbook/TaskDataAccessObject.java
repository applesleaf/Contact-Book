package com.example.contactbook;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TaskDataAccessObject {

    @Query("SELECT * FROM task ORDER BY priority")
    LiveData<List<Task>> loadAllTask();


    @Insert
    void insertTask(Task task);


    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(Task task);

    @Delete
    void deleteTask(Task task);

    @Query("SELECT * FROM task WHERE id = :id")
    LiveData<Task> getTaskById(int id);

}
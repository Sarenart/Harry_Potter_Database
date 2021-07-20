package com.example.harrypotterdatabase.model.databaseaccess;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.harrypotterdatabase.model.models.CharacterInfo;

import java.util.List;

@Dao
public interface CharacterInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CharacterInfo characterInfo);

    @Update
    void update(CharacterInfo characterInfo);

    @Delete
    void delete(CharacterInfo characterInfo);

    @Query("select * from characterInfo_table")
    LiveData<List<CharacterInfo>> getAll();

    @Query("select * from characterInfo_table where characterInfo_House like :house")
    LiveData<List<CharacterInfo>> getAllByHouse(String house);

    @Query("select * from characterInfo_table where characterInfo_Name like :name")
    CharacterInfo getCharacterByName(String name);
}

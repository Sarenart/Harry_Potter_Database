package com.example.harrypotterdatabase.model.databaseaccess;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.model.models.Wand;

@Database(entities = {CharacterInfo.class}, version = 1)
public abstract class HogwartsDatabase extends RoomDatabase {

    private static HogwartsDatabase instance;

    public abstract CharacterInfoDao getCharacterInfoDao();

    public static synchronized HogwartsDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), HogwartsDatabase.class, "HogwartsDb")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

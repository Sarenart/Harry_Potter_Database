package com.example.harrypotterdatabase.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.harrypotterdatabase.model.databaseaccess.HogwartsDatabase;
import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.model.service.HogwartsService;
import com.example.harrypotterdatabase.model.service.RetrofitInstance;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static Repository instance;

    private ExecutorService service;
    private final HogwartsService hogwartsService;
    private final HogwartsDatabase hogwartsDatabase;

    private ArrayList<CharacterInfo> characterInfoArrayList = new ArrayList<>();

    private final MutableLiveData <List<CharacterInfo>> mutableCharacterInfo = new MutableLiveData<>();

    public static Repository getInstance(Application application){
        if(instance == null){
            instance = new Repository(application);
        }
        return instance;
    }


    private Repository(Application application){
          hogwartsService = RetrofitInstance.getService();
          hogwartsDatabase = HogwartsDatabase.getInstance(application);

    }

    public LiveData<List<CharacterInfo>> getCharactersList(String house){

            //updateCharactersByHouseFromApi(house);
        //else getCharactersByHouseFromDatabase(house);
        //return mutableCharacterInfo;
        return hogwartsDatabase.getCharacterInfoDao().getAllByHouse(house);
    }


    public void /*LiveData<List<CharacterInfo>>*/ updateCharactersByHouseFromApi(String house){

        Call<List<CharacterInfo>> call = hogwartsService.getCharactersByHouse(house);

        call.enqueue(new Callback<List<CharacterInfo>>() {
            @Override
            public void onResponse(@NotNull Call<List<CharacterInfo>> call, @NotNull Response<List<CharacterInfo>> response) {
                List<CharacterInfo> characters = response.body();

                if(characters != null){

                    characterInfoArrayList = (ArrayList<CharacterInfo>) characters;
                    //mutableCharacterInfo.setValue(characters);
                    insertCharacterList(characterInfoArrayList);

                }
            }

            @Override
            public void onFailure(@NotNull Call<List<CharacterInfo>> call, @NotNull Throwable t) {

                Log.d("CHARACTER", "configure http: " + t.getMessage());

            }

        });

        //return mutableCharacterInfo;
    }


    public void insertCharacterList(ArrayList<CharacterInfo> CharacterInfo){

       service = Executors.newSingleThreadExecutor();

       service.execute(() -> {
                for(CharacterInfo info : CharacterInfo)
                {
                    hogwartsDatabase.getCharacterInfoDao().insert(info);
                }
            service.shutdown();
        });

    }


    public LiveData<List<CharacterInfo>> getCharactersByHouseFromDatabase(String house){
        return hogwartsDatabase.getCharacterInfoDao().getAllByHouse(house);
    }


}

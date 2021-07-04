package com.example.harrypotterdatabase.model;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.harrypotterdatabase.model.databaseaccess.HogwartsDatabase;
import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.model.service.HogwartsService;
import com.example.harrypotterdatabase.model.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static Repository instance;

    private final ExecutorService service;
    private final HogwartsService hogwartsService;
    private final HogwartsDatabase hogwartsDatabase;

    private ArrayList<CharacterInfo> characterInfoArrayList = new ArrayList<>();

    private LiveData<List<CharacterInfo>> characterInfos;

    private MutableLiveData <List<CharacterInfo>> mutableCharacterInfos = new MutableLiveData<>();

    public static Repository getInstance(Application application){
        if(instance == null){
            instance = new Repository(application);
        }
        return instance;
    }


    private Repository(Application application){
          hogwartsService = RetrofitInstance.getService();
          hogwartsDatabase = HogwartsDatabase.getInstance(application);
          service = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<CharacterInfo>> getCharacters(){

        Call<List<CharacterInfo>> call = hogwartsService.getCharacters();

        call.enqueue(new Callback<List<CharacterInfo>>() {
            @Override
            public void onResponse(Call<List<CharacterInfo>> call, Response<List<CharacterInfo>> response) {
                List<CharacterInfo> characters = response.body();

                if(characters != null){


                    characterInfoArrayList = (ArrayList<CharacterInfo>) characters;

                    mutableCharacterInfos.setValue(characters);

                    for (CharacterInfo characterInfo: characterInfoArrayList) {

                        Log.d("CHARACTER", characterInfo.getName() + ", " + characterInfo.getPatronus());

                    }
                }
            }

            @Override
            public void onFailure(Call<List<CharacterInfo>> call, Throwable t) {

                Log.d("CHARACTER", "configure http: " + t.getMessage());

            }

        });

        return mutableCharacterInfos;
    }

    public LiveData<List<CharacterInfo>> getCharactersByHouseFromApi(String house){

        Call<List<CharacterInfo>> call = hogwartsService.getCharactersByHouse(house);

        call.enqueue(new Callback<List<CharacterInfo>>() {
            @Override
            public void onResponse(Call<List<CharacterInfo>> call, Response<List<CharacterInfo>> response) {
                List<CharacterInfo> characters = response.body();

                if(characters != null){

                    characterInfoArrayList = (ArrayList<CharacterInfo>) characters;
                    mutableCharacterInfos.setValue(characters);

                    insertCharacterList(characterInfoArrayList);

                }
            }

            @Override
            public void onFailure(Call<List<CharacterInfo>> call, Throwable t) {

                Log.d("CHARACTER", "configure http: " + t.getMessage());

            }

        });

        return mutableCharacterInfos;
    }


    public void insertCharacterList(ArrayList<CharacterInfo> infos){

       service.execute(new Runnable() {
            @Override
            public void run() {
                for(CharacterInfo info : infos)
                {
                    if(hogwartsDatabase.getCharacterInfoDao().getCharacterByName(info.getName()) == null) {
                        hogwartsDatabase.getCharacterInfoDao().insert(info);
                    }
                    Log.d("Executors", "Multithread successful: " + info.getName() + info.getWand().getCore() + Thread.currentThread().getName());
                }
            }
        });

    }


    public LiveData<List<CharacterInfo>> getCharactersByHouseFromDatabase(String house){

        //characterInfos = (MutableLiveData<List<CharacterInfo>>) hogwartsDatabase.getCharacterInfoDao().getAll();
        characterInfos =  hogwartsDatabase.getCharacterInfoDao().getAllByHouse(house);
        return characterInfos;
        //TODO get rid of excessive LiveData field in Repository

    };


}

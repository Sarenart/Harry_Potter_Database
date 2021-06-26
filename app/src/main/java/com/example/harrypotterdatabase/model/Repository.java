package com.example.harrypotterdatabase.model;

import android.app.Application;
import android.util.Log;

import com.example.harrypotterdatabase.model.service.HogwartsService;
import com.example.harrypotterdatabase.model.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static Repository instance;

    private final HogwartsService hogwartsService;

    private ArrayList <CharacterInfo> characterInfoArrayList;

    public static Repository getInstance(){
        if(instance == null){
            instance = new Repository();
        }
        return instance;
    }

    private Repository(){
          hogwartsService = RetrofitInstance.getService();
    }

    public ArrayList<CharacterInfo> getCharacters(){

        Call<List<CharacterInfo>> call = hogwartsService.getCharacters();

        call.enqueue(new Callback<List<CharacterInfo>>() {
            @Override
            public void onResponse(Call<List<CharacterInfo>> call, Response<List<CharacterInfo>> response) {
                List<CharacterInfo> characters = response.body();

                if(characters != null){

                    characterInfoArrayList = (ArrayList<CharacterInfo>) characters;

                    for (CharacterInfo characterInfo: characterInfoArrayList) {

                        Log.d("CHARACTER", characterInfo.getName() + ", " + characterInfo.getActor());

                    }
                }
            }

            @Override
            public void onFailure(Call<List<CharacterInfo>> call, Throwable t) {

                Log.d("CHARACTER", "configure http: " + t.getMessage());

            }

        });

        return characterInfoArrayList;
    }
}

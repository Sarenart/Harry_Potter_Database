package com.example.harrypotterdatabase.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.harrypotterdatabase.model.models.CharacterInfo;
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

    private ArrayList<CharacterInfo> characterInfoArrayList = new ArrayList<>();
    private MutableLiveData<List<CharacterInfo>> mutableLiveData = new MutableLiveData<>();

    public static Repository getInstance(){
        if(instance == null){
            instance = new Repository();
        }
        return instance;
    }

    public LiveData<List<CharacterInfo>> getLiveData() {
        return mutableLiveData;
    }

    private Repository(){
          hogwartsService = RetrofitInstance.getService();
    }

    public LiveData<List<CharacterInfo>> getCharacters(){

        Call<List<CharacterInfo>> call = hogwartsService.getCharacters();

        call.enqueue(new Callback<List<CharacterInfo>>() {
            @Override
            public void onResponse(Call<List<CharacterInfo>> call, Response<List<CharacterInfo>> response) {
                List<CharacterInfo> characters = response.body();

                if(characters != null){

                    characterInfoArrayList = (ArrayList<CharacterInfo>) characters;

                    mutableLiveData.setValue(characters);

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

        return mutableLiveData;
    }

    public MutableLiveData<List<CharacterInfo>> getCharactersByHouse(String house){

        Call<List<CharacterInfo>> call = hogwartsService.getCharactersByHouse(house);

        call.enqueue(new Callback<List<CharacterInfo>>() {
            @Override
            public void onResponse(Call<List<CharacterInfo>> call, Response<List<CharacterInfo>> response) {
                List<CharacterInfo> characters = response.body();

                if(characters != null){

                    characterInfoArrayList = (ArrayList<CharacterInfo>) characters;

                    mutableLiveData.setValue(characters);

                    for (CharacterInfo characterInfo: characterInfoArrayList) {

                        Log.d("CHARACTER", characterInfo.getName() + ", " + characterInfo.getHouse());

                    }
                }
            }

            @Override
            public void onFailure(Call<List<CharacterInfo>> call, Throwable t) {

                Log.d("CHARACTER", "configure http: " + t.getMessage());

            }

        });

        return mutableLiveData;
    }


}

package com.example.harrypotterdatabase.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.harrypotterdatabase.model.CharacterInfo;
import com.example.harrypotterdatabase.model.service.HogwartsService;
import com.example.harrypotterdatabase.model.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private HogwartsService hogwartsService;

    ArrayList <CharacterInfo> characterInfoArrayList;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

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

                Log.d("CHARACTER", "configure http " + t.getMessage());

            }

        });

        return characterInfoArrayList;
    }

}

package com.example.harrypotterdatabase.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.harrypotterdatabase.model.CharacterInfo;
import com.example.harrypotterdatabase.model.Repository;
import com.example.harrypotterdatabase.model.service.HogwartsService;
import com.example.harrypotterdatabase.model.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private final Repository repository;

    private ArrayList <CharacterInfo> characterInfoArrayList;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        repository = Repository.getInstance();
    }

    public ArrayList<CharacterInfo> getCharacters(){ return this.repository.getCharacters(); }

}

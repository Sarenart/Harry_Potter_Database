package com.example.harrypotterdatabase.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.model.Repository;
import com.example.harrypotterdatabase.model.models.Wand;
import com.example.harrypotterdatabase.model.service.HogwartsService;

import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends AndroidViewModel {

    private final Repository repository;

    private boolean isListLoaded;
    private int dataSource;

    private LiveData<List<CharacterInfo>> charactersByHouse;

    private MutableLiveData<CharacterInfo> chosenCharacter = new MutableLiveData<>();

    private MutableLiveData<String> chosenHouse = new MutableLiveData<>();

    private MutableLiveData<Wand> chosenWand = new MutableLiveData<>();

    public SharedViewModel(@NonNull Application application) {
        super(application);

        repository = Repository.getInstance(application);
        isListLoaded = false;
    }

    public MutableLiveData<CharacterInfo> getChosenCharacter() {
        return chosenCharacter;
    }


    public MutableLiveData<String> getChosenHouse() {
        return chosenHouse;
    }

    public MutableLiveData<Wand> getChosenWand() { return chosenWand;  }

    public boolean isListLoaded() {
        return isListLoaded;
    }

    public void setListLoaded(boolean listLoaded) {
        isListLoaded = listLoaded;
    }

    public LiveData<List<CharacterInfo>> getAllCharacters(){

        return repository.getCharacters();

    }

    public LiveData<List<CharacterInfo>> getCharactersByHouse(String house){

        charactersByHouse = repository.getCharactersByHouseFromApi(house);
        return charactersByHouse;

    }



}

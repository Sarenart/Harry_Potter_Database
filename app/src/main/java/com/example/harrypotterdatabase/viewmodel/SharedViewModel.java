package com.example.harrypotterdatabase.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.harrypotterdatabase.model.Constants;
import com.example.harrypotterdatabase.model.GlobalVariables;
import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.model.Repository;
import com.example.harrypotterdatabase.model.models.Wand;
import com.example.harrypotterdatabase.model.service.HogwartsService;

import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends AndroidViewModel {

    private final Repository repository;

    //private LiveData<List<CharacterInfo>> charactersByHouse;

    private boolean isDataInvalidated;

    private final MutableLiveData<CharacterInfo> chosenCharacter = new MutableLiveData<>();

    private final MutableLiveData<String> chosenHouse = new MutableLiveData<>();

    private final MutableLiveData<Wand> chosenWand = new MutableLiveData<>();

    public boolean isDataInvalidated() {
        return isDataInvalidated;
    }

    public void setDataInvalidated(boolean dataInvalidated) {
        isDataInvalidated = dataInvalidated;
    }

    public SharedViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
        //charactersByHouse = repository.getCharactersList();
        //isDataInvalidated = true;
    }


    public MutableLiveData<CharacterInfo> getChosenCharacter() {
        return chosenCharacter;
    }


    public MutableLiveData<String> getChosenHouse() {
        return chosenHouse;
    }

    public MutableLiveData<Wand> getChosenWand() { return chosenWand;  }


    public LiveData<List<CharacterInfo>> getCharactersByHouse(String house){

        return repository.getCharactersList(house);
        /*
        if(GlobalVariables.isNetworkConnected) {
            charactersByHouse = repository.getCharactersByHouseFromApi(house);
        }
        else charactersByHouse = repository.getCharactersByHouseFromDatabase(house);

        return charactersByHouse;*/
    }

    public void updateCharactersByHouse(String house){
        repository.updateCharactersByHouseFromApi(house);
    };

}

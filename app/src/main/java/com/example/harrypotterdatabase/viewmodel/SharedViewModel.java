package com.example.harrypotterdatabase.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.harrypotterdatabase.model.Constants;
import com.example.harrypotterdatabase.model.GlobalVariables;
import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.model.Repository;
import com.example.harrypotterdatabase.model.models.Wand;
import com.example.harrypotterdatabase.model.service.HogwartsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SharedViewModel extends AndroidViewModel {

    private final Repository repository;

    Observer<List<CharacterInfo>> observer;

    private MutableLiveData<Boolean> isCharacterRedacted = new MutableLiveData<>();

    private final MutableLiveData<CharacterInfo> chosenCharacter = new MutableLiveData<>();

    private final MutableLiveData<String> chosenHouse = new MutableLiveData<>();

    private final MutableLiveData<Wand> chosenWand = new MutableLiveData<>();

    private final MutableLiveData<List<CharacterInfo>> originalCharacterList = new MutableLiveData<>();

    private final MutableLiveData<List<CharacterInfo>> filteredCharacterList = new MutableLiveData<>();

    public SharedViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
        observer = characterInfos -> {
            originalCharacterList.setValue(characterInfos);
            filteredCharacterList.setValue(characterInfos);
        };

    }


    public MutableLiveData<CharacterInfo> getChosenCharacter() {
        return chosenCharacter;
    }


    public MutableLiveData<String> getChosenHouse() {
        return chosenHouse;
    }

    public MutableLiveData<Wand> getChosenWand() { return chosenWand;  }


    public LiveData<List<CharacterInfo>> getCharactersByHouse(String house){

        repository.getCharactersList(house).observeForever(observer);
        return filteredCharacterList;
    }

    public void updateCharactersByHouse(String house){
        repository.updateCharactersByHouseFromApi(house);
    }

    public void removeObserversFromLiveData(){
        repository.getCharactersList(chosenHouse.getValue()).removeObserver(observer);
    }

    public void filterCharacters(String subString){
        List<CharacterInfo> filteredList = new ArrayList<>();
        List<CharacterInfo> originalList = new ArrayList<>(Objects.requireNonNull(originalCharacterList.getValue()));
        for(CharacterInfo characterInfo: originalList)
            if(characterInfo.getName().toUpperCase().contains(subString.toUpperCase()))
                filteredList.add(characterInfo);
        filteredCharacterList.setValue(filteredList);
        originalCharacterList.setValue(originalList);
    }

    public void setOriginalList() {
        filteredCharacterList.setValue(originalCharacterList.getValue());
    }

    public MutableLiveData<Boolean> getIsCharacterRedacted() {
        return isCharacterRedacted;
    }

    public void setIsCharacterRedacted(boolean isCharacterRedacted) {
        this.isCharacterRedacted.setValue(isCharacterRedacted);
    }

    public void UpdateChosenCharacter() {
        repository.updateCharacter(chosenCharacter.getValue());
        setIsCharacterRedacted(false);
    }
}

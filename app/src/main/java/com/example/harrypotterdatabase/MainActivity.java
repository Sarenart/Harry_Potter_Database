package com.example.harrypotterdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.harrypotterdatabase.fragments.CharactersFragment;
import com.example.harrypotterdatabase.fragments.HousesFragment;
import com.example.harrypotterdatabase.model.CharacterInfo;
import com.example.harrypotterdatabase.model.service.HogwartsService;
import com.example.harrypotterdatabase.model.service.RetrofitInstance;
import com.example.harrypotterdatabase.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    private ArrayList<CharacterInfo> characterArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(MainActivityViewModel.class);

        characterArrayList = mainActivityViewModel.getCharacters();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.buttonPanelContainerView, HousesFragment.class, null)
                    .commit();
        }
    }

}
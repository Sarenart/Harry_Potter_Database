package com.example.harrypotterdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.harrypotterdatabase.fragments.CharacterInfoFragment;
import com.example.harrypotterdatabase.fragments.CharacterListFragment;
import com.example.harrypotterdatabase.fragments.HousesFragment;
import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.model.service.HogwartsService;
import com.example.harrypotterdatabase.viewmodel.SharedViewModel;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SharedViewModel sharedViewModel;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*sharedViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(SharedViewModel.class);*/
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        fragmentManager = getSupportFragmentManager();
       // sharedViewModel.getAllCharacters();

        sharedViewModel.getChosenHouse().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                fragmentManager.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.buttonPanelContainerView, CharacterListFragment.class, null)
                        .addToBackStack("CharactersByHouse")
                        .commit();
               // sharedViewModel.getCharactersByHouse(s);
            }
        });
        sharedViewModel.getChosenCharacter().observe(this, new Observer<CharacterInfo>() {
            @Override
            public void onChanged(CharacterInfo characterInfo) {
                fragmentManager.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.buttonPanelContainerView, CharacterInfoFragment.class, null)
                        .addToBackStack("CharactersByHouse")
                        .commit();
            }
        });


        if(savedInstanceState == null){
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.buttonPanelContainerView, HousesFragment.class, null)
                    .addToBackStack("Houses")
                    .commit();
        }
    }


}
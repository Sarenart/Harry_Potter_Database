package com.example.harrypotterdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.harrypotterdatabase.fragments.HousesFragment;
import com.example.harrypotterdatabase.model.service.HogwartsService;
import com.example.harrypotterdatabase.viewmodel.SharedViewModel;

public class CharacterListActivity extends AppCompatActivity {

    SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);

        sharedViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(SharedViewModel.class);

        sharedViewModel.getCharactersByHouse(HogwartsService.GRYFFINDOR);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.buttonPanelContainerView, HousesFragment.class, null)
                    .addToBackStack("Houses")
                    .commit();
        }
    }
}
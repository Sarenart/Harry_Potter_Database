package com.example.harrypotterdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.harrypotterdatabase.fragments.CharacterInfoFragment;
import com.example.harrypotterdatabase.fragments.CharacterInfoFragmentDirections;
import com.example.harrypotterdatabase.fragments.CharacterListFragment;
import com.example.harrypotterdatabase.fragments.CharacterListFragmentDirections;
import com.example.harrypotterdatabase.fragments.HousesFragment;
import com.example.harrypotterdatabase.fragments.HousesFragmentDirections;
import com.example.harrypotterdatabase.fragments.WandInfoFragment;
import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.model.models.Wand;
import com.example.harrypotterdatabase.viewmodel.SharedViewModel;

public class MainActivity extends AppCompatActivity {

    private SharedViewModel sharedViewModel;
    private FragmentManager fragmentManager;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager
                .findFragmentById(R.id.navHostContainerView);
        navController = navHostFragment.getNavController();

        sharedViewModel.getChosenHouse().observe(this, new Observer<String>() {

            @Override
            public void onChanged(String s) {

                sharedViewModel.setListLoaded(false);
                NavDirections action = HousesFragmentDirections
                        .actionHousesFragmentToCharacterListFragment();
                navController.navigate(action);


            }
        });
        sharedViewModel.getChosenCharacter().observe(this, new Observer<CharacterInfo>() {
            @Override
            public void onChanged(CharacterInfo characterInfo) {

                NavDirections action = CharacterListFragmentDirections
                        .actionCharacterListFragmentToCharacterInfoFragment();
                navController.navigate(action);


            }
        });

        sharedViewModel.getChosenWand().observe(this, new Observer<Wand>() {
            @Override
            public void onChanged(Wand wand) {

                NavDirections action = CharacterInfoFragmentDirections
                        .actionCharacterInfoFragmentToWandInfoFragment();
                navController.navigate(action);

            }
        });


        if(savedInstanceState == null){

        }
    }

    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
        fragmentManager.popBackStack();
    }*/
}
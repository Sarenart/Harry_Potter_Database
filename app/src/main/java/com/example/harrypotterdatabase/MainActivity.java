package com.example.harrypotterdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import com.example.harrypotterdatabase.fragments.CharacterInfoFragment;
import com.example.harrypotterdatabase.fragments.CharacterInfoFragmentDirections;
import com.example.harrypotterdatabase.fragments.CharacterListFragment;
import com.example.harrypotterdatabase.fragments.CharacterListFragmentDirections;
import com.example.harrypotterdatabase.fragments.CharacterUpdateFragment;
import com.example.harrypotterdatabase.fragments.HousesFragment;
import com.example.harrypotterdatabase.fragments.HousesFragmentDirections;
import com.example.harrypotterdatabase.fragments.WandInfoFragment;
import com.example.harrypotterdatabase.model.Constants;
import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.model.models.Wand;
import com.example.harrypotterdatabase.network.CheckNetwork;
import com.example.harrypotterdatabase.viewmodel.SharedViewModel;

public class MainActivity extends AppCompatActivity {

    private SharedViewModel sharedViewModel;
    private FragmentManager fragmentManager;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        fragmentManager = getSupportFragmentManager();

        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager
                .findFragmentById(R.id.navHostContainerView);
        
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();

        appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        CheckNetwork checkNetwork = new CheckNetwork(getApplicationContext(), fragmentManager);
        checkNetwork.registerNetworkCallback();

        sharedViewModel.getChosenHouse().observe(this, s -> {
            sharedViewModel.updateCharactersByHouse(s);
            NavDirections action = HousesFragmentDirections
                    .actionHousesFragmentToCharacterListFragment();
            navController.navigate(action);
        });
        sharedViewModel.getChosenCharacter().observe(this, characterInfo -> {
            NavDirections action = CharacterListFragmentDirections
                    .actionCharacterListFragmentToCharacterInfoFragment();
            navController.navigate(action);
        });

        sharedViewModel.getChosenWand().observe(this, wand -> {

            NavDirections action = CharacterInfoFragmentDirections
                    .actionCharacterInfoFragmentToWandInfoFragment();
            navController.navigate(action);

        });
        sharedViewModel.getIsCharacterRedacted().observe(this, aBoolean -> {
            if(aBoolean) {
                NavDirections action = CharacterInfoFragmentDirections
                        .actionCharacterInfoFragmentToCharacterUpdateFragment();
                navController.navigate(action);
            }
            else {

                navController.popBackStack();
            }
        });


    }



    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().findFragmentById(R.id.characterListFragment)==null) {
            Log.d("List", "List was deleted");

        }

    }
}
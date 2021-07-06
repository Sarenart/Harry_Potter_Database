package com.example.harrypotterdatabase.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harrypotterdatabase.R;
import com.example.harrypotterdatabase.databinding.FragmentHousesBinding;
import com.example.harrypotterdatabase.model.service.HogwartsService;
import com.example.harrypotterdatabase.viewmodel.SharedViewModel;

import org.jetbrains.annotations.NotNull;

import java.net.HttpURLConnection;


public class HousesFragment extends Fragment {

    private SharedViewModel sharedViewModel;

    private FragmentHousesBinding fragmentHousesBinding;

    private HousesClickHandlers housesClickHandlers;


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

        housesClickHandlers = new HousesClickHandlers(this.requireActivity());

        fragmentHousesBinding.setHousesClickHandlers(housesClickHandlers);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_houses, container, false);

        fragmentHousesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_houses, container, false);
        return fragmentHousesBinding.getRoot();
    }

    public class HousesClickHandlers{
        Context context;

        public HousesClickHandlers(Context context){ this.context = context; }

        public void onGryffindorClicked(View view){
            sharedViewModel.getChosenHouse().setValue(HogwartsService.GRYFFINDOR);
        }
        public void onHufflepuffClicked(View view){
            sharedViewModel.getChosenHouse().setValue(HogwartsService.HUFFLEPUFF);
        }
        public void onRavenclawClicked(View view){
            sharedViewModel.getChosenHouse().setValue(HogwartsService.RAVENCLAW);
        }
        public void onSlytherinClicked(View view){
            sharedViewModel.getChosenHouse().setValue(HogwartsService.SLYTHERIN);
        }

    }
}
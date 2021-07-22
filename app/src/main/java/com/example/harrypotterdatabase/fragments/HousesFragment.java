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
import com.example.harrypotterdatabase.model.Constants;
import com.example.harrypotterdatabase.model.service.HogwartsService;
import com.example.harrypotterdatabase.viewmodel.SharedViewModel;

import org.jetbrains.annotations.NotNull;

import java.net.HttpURLConnection;


public class HousesFragment extends BasicFragment {

    private FragmentHousesBinding fragmentHousesBinding;


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HousesClickHandlers housesClickHandlers = new HousesClickHandlers(this.requireActivity());

        fragmentHousesBinding.setHousesClickHandlers(housesClickHandlers);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentHousesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_houses, container, false);
        return fragmentHousesBinding.getRoot();
    }

    public class HousesClickHandlers{
        Context context;

        public HousesClickHandlers(Context context){ this.context = context; }

        public void onGryffindorClicked(View view){
             HousesFragment.this.getSharedViewModel().getChosenHouse().setValue(Constants.GRYFFINDOR);
        }
        public void onHufflepuffClicked(View view){
            HousesFragment.this.getSharedViewModel().getChosenHouse().setValue(Constants.HUFFLEPUFF);
        }
        public void onRavenclawClicked(View view){
            HousesFragment.this.getSharedViewModel().getChosenHouse().setValue(Constants.RAVENCLAW);
        }
        public void onSlytherinClicked(View view){
            HousesFragment.this.getSharedViewModel().getChosenHouse().setValue(Constants.SLYTHERIN);
        }

    }
}
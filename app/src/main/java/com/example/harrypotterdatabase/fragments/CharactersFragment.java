package com.example.harrypotterdatabase.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harrypotterdatabase.R;
import com.example.harrypotterdatabase.viewmodel.MainActivityViewModel;


public class CharactersFragment extends Fragment {

    MainActivityViewModel mainActivityViewModel;


    public CharactersFragment() {
        super(R.layout.fragment_characters);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivityViewModel = new ViewModelProvider(requireActivity())
                .get(MainActivityViewModel.class);
    }
}
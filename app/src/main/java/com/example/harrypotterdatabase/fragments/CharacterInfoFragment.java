package com.example.harrypotterdatabase.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harrypotterdatabase.R;
import com.example.harrypotterdatabase.databinding.FragmentCharacterInfoBinding;
import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.model.service.HogwartsService;
import com.example.harrypotterdatabase.viewmodel.SharedViewModel;

import java.util.ArrayList;
import java.util.List;


public class CharacterInfoFragment extends Fragment {

    private SharedViewModel sharedViewModel;
    private CharacterInfo chosenCharacter;

    private FragmentCharacterInfoBinding fragmentCharacterInfoBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

        fragmentCharacterInfoBinding.setCharacter(sharedViewModel.getChosenCharacter().getValue());
        Log.d("State", "OnViewCreated");
        Log.d("Wand", sharedViewModel.getChosenCharacter().getValue().getWand().getCore());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("State", "OnCreateView");
        fragmentCharacterInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_info, container, false);
        View view = fragmentCharacterInfoBinding.getRoot();
        return view;
    }

    public class CharacterInfoClickHandlers{
        Context context;

        public CharacterInfoClickHandlers(Context context){ this.context = context; }

        public void onShowWandButtonClicked(View view){
            sharedViewModel.getChosenHouse().setValue(HogwartsService.GRYFFINDOR);
        }
    }
}
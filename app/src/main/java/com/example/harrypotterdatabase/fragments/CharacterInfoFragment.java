package com.example.harrypotterdatabase.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CharacterInfoFragment extends Fragment {

    private SharedViewModel sharedViewModel;
    private CharacterInfo chosenCharacter;

    private FragmentCharacterInfoBinding fragmentCharacterInfoBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //get sharedViewModel instance
        sharedViewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

        //set character info to View
        fragmentCharacterInfoBinding.setCharacter(sharedViewModel.getChosenCharacter().getValue());
        fragmentCharacterInfoBinding.setClickHandlers(new CharacterInfoClickHandlers(requireContext()));

        Log.d("State", "OnViewCreated");

    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("State", "OnCreateView");

        //get DataBinding instance
        fragmentCharacterInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_info, container, false);
        return fragmentCharacterInfoBinding.getRoot();
    }

    public class CharacterInfoClickHandlers{
        Context context;

        public CharacterInfoClickHandlers(Context context){ this.context = context; }
        /*
            set character's wand to invoke transition to Wand Info Fragment from MainActivity
         */
        public void onShowWandButtonClicked(View view){
            sharedViewModel.getChosenWand().setValue(Objects.requireNonNull(sharedViewModel.getChosenCharacter().getValue()).getWand());
        }
    }
}
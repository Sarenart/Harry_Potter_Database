package com.example.harrypotterdatabase.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
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


public class CharacterInfoFragment extends BasicFragment {

    private FragmentCharacterInfoBinding fragmentCharacterInfoBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentCharacterInfoBinding.setCharacter(getSharedViewModel().getChosenCharacter().getValue());
        fragmentCharacterInfoBinding.setClickHandlers(new CharacterInfoClickHandlers(requireContext()));

    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentCharacterInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_info, container, false);
        return fragmentCharacterInfoBinding.getRoot();
    }

    public class CharacterInfoClickHandlers{
        Context context;

        public CharacterInfoClickHandlers(Context context){ this.context = context; }

        public void onShowWandButtonClicked(View view){
            CharacterInfoFragment.this.getSharedViewModel().getChosenWand().setValue(Objects.requireNonNull(CharacterInfoFragment.this.getSharedViewModel().getChosenCharacter().getValue()).getWand());
        }
        public void onUpdateButtonClicked(View view){
            CharacterInfoFragment.this.getSharedViewModel().setIsCharacterRedacted(true);
        }
    }
}
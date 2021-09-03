package com.example.harrypotterdatabase.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.harrypotterdatabase.R;
import com.example.harrypotterdatabase.databinding.FragmentCharacterUpdateBinding;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CharacterUpdateFragment extends BasicFragment {

    private FragmentCharacterUpdateBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_update, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.setCharacter(getSharedViewModel().getChosenCharacter().getValue());
        binding.setClickHandlers(new CharacterUpdateClickHandlers(getContext()));
    }

    public class CharacterUpdateClickHandlers{
        Context context;

        public CharacterUpdateClickHandlers(Context context){ this.context = context; }

        public void onUpdateButtonClicked(View view){
            CharacterUpdateFragment.this.getSharedViewModel().UpdateChosenCharacter();
            Toast.makeText(getContext(),"Character updated", Toast.LENGTH_SHORT).show();
        }
    }
}
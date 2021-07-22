package com.example.harrypotterdatabase.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harrypotterdatabase.R;
import com.example.harrypotterdatabase.databinding.FragmentWandInfoBinding;
import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.model.models.Wand;
import com.example.harrypotterdatabase.viewmodel.SharedViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WandInfoFragment extends BasicFragment {


    private FragmentWandInfoBinding fragmentWandInfoBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentWandInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_wand_info, container, false);
        return fragmentWandInfoBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentWandInfoBinding.setWand(getSharedViewModel().getChosenWand().getValue());
        fragmentWandInfoBinding.setName(Objects.requireNonNull(getSharedViewModel().getChosenCharacter().getValue()).getName());
    }
}
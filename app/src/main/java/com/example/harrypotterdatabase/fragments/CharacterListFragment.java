package com.example.harrypotterdatabase.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harrypotterdatabase.R;
import com.example.harrypotterdatabase.adapters.CharacterRecyclerViewAdapter;
import com.example.harrypotterdatabase.databinding.FragmentCharacterListBinding;
import com.example.harrypotterdatabase.model.models.CharacterInfo;
import com.example.harrypotterdatabase.viewmodel.SharedViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class CharacterListFragment extends Fragment {

    private SharedViewModel sharedViewModel;

    private ArrayList<CharacterInfo> characterInfoArrayList;

    private FragmentCharacterListBinding fragmentCharacterListBinding;

    private CharacterRecyclerViewAdapter characterRecyclerViewAdapter;

    View inflatedView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Log.d("State", "OnСreate");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

        sharedViewModel.getCharactersByHouse(sharedViewModel.getChosenHouse().getValue())
                .observe(requireActivity(), (characterInfoList) -> {
                        characterRecyclerViewAdapter.setCharacterInfoArrayList((ArrayList<CharacterInfo>) characterInfoList);
                });
        Log.d("State", "OnViewCreated");
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("State", "OnCreateView");
        fragmentCharacterListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_list, container, false);
        View view = fragmentCharacterListBinding.getRoot();
        updateCharacterList();
        return view;

    }

    @Override
    public void onDestroyView() {
        Log.d("State", "OnDestroy");
        super.onDestroyView();
        //characterRecyclerViewAdapter.clearCharacterInfoArrayList();
        //fragmentCharacterListBinding = null;
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("State", "OnStop");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("State", "OnResume");

    }

    private void updateCharacterList(){

        RecyclerView characterRecyclerView = fragmentCharacterListBinding.characterRecyclerView;
        characterRecyclerView.setLayoutManager(new GridLayoutManager(requireActivity(), 2));
        characterRecyclerView.setHasFixedSize(true);

        characterRecyclerViewAdapter = new CharacterRecyclerViewAdapter();

        characterRecyclerView.setAdapter(characterRecyclerViewAdapter);
        characterRecyclerViewAdapter.setOnItemClickListener((characterInfo) -> sharedViewModel.getChosenCharacter().setValue(characterInfo));

    }


}
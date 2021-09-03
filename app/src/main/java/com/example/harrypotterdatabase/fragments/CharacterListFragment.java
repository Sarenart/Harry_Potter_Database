package com.example.harrypotterdatabase.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
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


public class CharacterListFragment extends BasicFragment {

    private FragmentCharacterListBinding fragmentCharacterListBinding;

    private CharacterRecyclerViewAdapter characterRecyclerViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Log.d("State", "OnСreate");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setCharacterList();
        getSharedViewModel().getCharactersByHouse(getSharedViewModel().getChosenHouse().getValue())
                .observe(requireActivity(), (characterInfoList) -> {
                        if(characterInfoList !=null)
                        characterRecyclerViewAdapter.setCharacterInfoArrayList((ArrayList<CharacterInfo>) characterInfoList);
                });

        fragmentCharacterListBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!newText.equals("")) {
                    getSharedViewModel().filterCharacters(newText);
                }
                else getSharedViewModel().setOriginalList();
                return false;
            }
        });
        Log.d("State", "OnViewCreated");
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("State", "OnCreateView");
        fragmentCharacterListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_list, container, false);
        return fragmentCharacterListBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        Log.d("State", "OnDestroyView");
        super.onDestroyView();
        getSharedViewModel().getCharactersByHouse(getSharedViewModel().getChosenHouse().getValue()).removeObservers(requireActivity());
        characterRecyclerViewAdapter.clearCharacterInfoArrayList();
        getSharedViewModel().removeObserversFromLiveData();
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

    private void setCharacterList(){

        RecyclerView characterRecyclerView = fragmentCharacterListBinding.characterRecyclerView;
        characterRecyclerView.setLayoutManager(new GridLayoutManager(requireActivity(), 2));
        characterRecyclerView.setHasFixedSize(true);

        characterRecyclerViewAdapter = new CharacterRecyclerViewAdapter();

        characterRecyclerView.setAdapter(characterRecyclerViewAdapter);
        characterRecyclerViewAdapter.setOnItemClickListener((characterInfo) -> getSharedViewModel().getChosenCharacter().setValue(characterInfo));

    }

}
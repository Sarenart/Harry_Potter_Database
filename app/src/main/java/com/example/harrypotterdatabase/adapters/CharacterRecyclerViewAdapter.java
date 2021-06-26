package com.example.harrypotterdatabase.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harrypotterdatabase.R;
import com.example.harrypotterdatabase.databinding.CharacterItemViewBinding;
import com.example.harrypotterdatabase.model.CharacterInfo;

import java.util.ArrayList;

public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterRecyclerViewAdapter.CharacterViewHolder> {

    private OnItemClickListener onItemClickListener;
    private ArrayList<CharacterInfo> characterInfoArrayList = new ArrayList<>();

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CharacterItemViewBinding characterItemViewBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.fragment_characters,
                parent, false
        );
        return new CharacterViewHolder(characterItemViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull  CharacterRecyclerViewAdapter.CharacterViewHolder holder, int position) {
        CharacterInfo characterInfo = characterInfoArrayList.get(position);
        holder.characterItemViewBinding.setCharacter(characterInfo);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class CharacterViewHolder extends RecyclerView.ViewHolder{

        CharacterItemViewBinding characterItemViewBinding;

        public CharacterViewHolder(@NonNull CharacterItemViewBinding characterItemViewBinding) {
            super(characterItemViewBinding.getRoot());

            this.characterItemViewBinding = characterItemViewBinding;

            characterItemViewBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    if(onItemClickListener != null & position !=RecyclerView.NO_POSITION)
                    onItemClickListener.onItemClick(characterInfoArrayList.get(position));
                }
            });
        }
    }

    public interface OnItemClickListener{

        void onItemClick(CharacterInfo characterInfo);

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}

package com.example.harrypotterdatabase.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harrypotterdatabase.R;
import com.example.harrypotterdatabase.databinding.CharacterListItemViewBinding;
import com.example.harrypotterdatabase.model.models.CharacterInfo;

import java.util.ArrayList;

public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterRecyclerViewAdapter.CharacterViewHolder> {

    private OnItemClickListener onItemClickListener;
    private ArrayList<CharacterInfo> characterInfoArrayList = new ArrayList<>();

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CharacterListItemViewBinding characterListItemViewBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.character_list_item_view,
                parent, false
        );
        return new CharacterViewHolder(characterListItemViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull  CharacterRecyclerViewAdapter.CharacterViewHolder holder, int position) {
        CharacterInfo characterInfo = characterInfoArrayList.get(position);
        holder.characterListItemViewBinding.setCharacter(characterInfo);
    }

    @Override
    public int getItemCount() {
        return characterInfoArrayList.size();
    }


    class CharacterViewHolder extends RecyclerView.ViewHolder{

        CharacterListItemViewBinding characterListItemViewBinding;

        public CharacterViewHolder(@NonNull CharacterListItemViewBinding characterListItemViewBinding) {
            super(characterListItemViewBinding.getRoot());

            this.characterListItemViewBinding = characterListItemViewBinding;

            characterListItemViewBinding.getRoot().setOnClickListener(new View.OnClickListener() {
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

    public void setCharacterInfoArrayList(ArrayList<CharacterInfo> characterInfoArrayList) {
        clearCharacterInfoArrayList();
        this.characterInfoArrayList = characterInfoArrayList;
        notifyDataSetChanged();
    }

    public void clearCharacterInfoArrayList(){
        this.characterInfoArrayList.clear();
    }
}

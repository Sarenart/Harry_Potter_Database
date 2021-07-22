package com.example.harrypotterdatabase.model.models;

import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Wand extends BaseObservable  {


    @ColumnInfo(name="wand_Wood")
    @SerializedName("wood")
    @Expose
    private String wood;

    @ColumnInfo(name="wand_Core")
    @SerializedName("core")
    @Expose
    private String core;

    @ColumnInfo(name="wand_Length")
    @SerializedName("length")
    @Expose
    private String length;

    @Bindable
    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    @Bindable
    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    @Bindable
    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

}
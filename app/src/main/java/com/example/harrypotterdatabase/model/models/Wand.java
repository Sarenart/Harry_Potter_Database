package com.example.harrypotterdatabase.model.models;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wand implements Parcelable {

    @SerializedName("wood")
    @Expose
    private String wood;
    @SerializedName("core")
    @Expose
    private String core;
    @SerializedName("length")
    @Expose
    private String length;
    public final static Creator<Wand> CREATOR = new Creator<Wand>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Wand createFromParcel(android.os.Parcel in) {
            return new Wand(in);
        }

        public Wand[] newArray(int size) {
            return (new Wand[size]);
        }

    }
            ;

    protected Wand(android.os.Parcel in) {
        this.wood = ((String) in.readValue((String.class.getClassLoader())));
        this.core = ((String) in.readValue((String.class.getClassLoader())));
        this.length = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Wand() {
    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(wood);
        dest.writeValue(core);
        dest.writeValue(length);
    }

    public int describeContents() {
        return 0;
    }



}
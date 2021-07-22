package com.example.harrypotterdatabase.model.models;

//import javax.annotation.Generated;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "characterInfo_table")
public class CharacterInfo extends BaseObservable  {

    @ColumnInfo(name="characterInfo_Name")
    @SerializedName("name")
    @Expose
    @PrimaryKey
    @NonNull
    private String name;

    @ColumnInfo(name="characterInfo_Species")
    @SerializedName("species")
    @Expose
    private String species;


    @ColumnInfo(name="characterInfo_Gender")
    @SerializedName("gender")
    @Expose
    private String gender;

    @ColumnInfo(name="characterInfo_House")
    @SerializedName("house")
    @Expose
    private String house;

    @ColumnInfo(name="characterInfo_DateOfBirth")
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;

    @ColumnInfo(name="characterInfo_YearOfBirth")
    @SerializedName("yearOfBirth")
    @Expose
    private String yearOfBirth;


    @ColumnInfo(name="characterInfo_Ancestry")
    @SerializedName("ancestry")
    @Expose
    private String ancestry;

    @ColumnInfo(name="characterInfo_EyeColour")
    @SerializedName("eyeColour")
    @Expose
    private String eyeColour;

    @ColumnInfo(name="characterInfo_HairColour")
    @SerializedName("hairColour")
    @Expose
    private String hairColour;


    @SerializedName("wand")
    @Expose
    @Embedded private Wand wand;

    @ColumnInfo(name="characterInfo_Patronus")
    @SerializedName("patronus")
    @Expose
    private String patronus;

    @ColumnInfo(name="characterInfo_HogwartsStudent")
    @SerializedName("hogwartsStudent")
    @Expose
    private Boolean hogwartsStudent;

    @ColumnInfo(name="characterInfo_HogwartsStaff")
    @SerializedName("hogwartsStaff")
    @Expose
    private Boolean hogwartsStaff;

    @ColumnInfo(name="characterInfo_Actor")
    @SerializedName("actor")
    @Expose
    private String actor;

    @ColumnInfo(name="characterInfo_Alive")
    @SerializedName("alive")
    @Expose
    private Boolean alive;

    @ColumnInfo(name="characterInfo_Image")
    @SerializedName("image")
    @Expose
    private String image;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Bindable
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Bindable
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Bindable
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Bindable
    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Bindable
    public String getAncestry() {
        return ancestry;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    @Bindable
    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    @Bindable
    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    @Bindable
    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    @Bindable
    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    @Bindable
    public Boolean getHogwartsStudent() {
        return hogwartsStudent;
    }

    public void setHogwartsStudent(Boolean hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    @Bindable
    public Boolean getHogwartsStaff() {
        return hogwartsStaff;
    }

    public void setHogwartsStaff(Boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    @Bindable
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Bindable
    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}



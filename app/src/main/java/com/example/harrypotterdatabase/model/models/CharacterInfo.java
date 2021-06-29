package com.example.harrypotterdatabase.model.models;

//import javax.annotation.Generated;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class CharacterInfo implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("species")
    @Expose
    private String species;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("house")
    @Expose
    private String house;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("yearOfBirth")
    @Expose
    private String yearOfBirth;
    @SerializedName("ancestry")
    @Expose
    private String ancestry;
    @SerializedName("eyeColour")
    @Expose
    private String eyeColour;
    @SerializedName("hairColour")
    @Expose
    private String hairColour;
    @SerializedName("wand")
    @Expose
    private Wand wand;
    @SerializedName("patronus")
    @Expose
    private String patronus;
    @SerializedName("hogwartsStudent")
    @Expose
    private Boolean hogwartsStudent;
    @SerializedName("hogwartsStaff")
    @Expose
    private Boolean hogwartsStaff;
    @SerializedName("actor")
    @Expose
    private String actor;
    @SerializedName("alive")
    @Expose
    private Boolean alive;
    @SerializedName("image")
    @Expose
    private String image;
    public final static Creator<CharacterInfo> CREATOR = new Creator<CharacterInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CharacterInfo createFromParcel(android.os.Parcel in) {
            return new CharacterInfo(in);
        }

        public CharacterInfo[] newArray(int size) {
            return (new CharacterInfo[size]);
        }

    }
            ;

    protected CharacterInfo(android.os.Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.species = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.house = ((String) in.readValue((String.class.getClassLoader())));
        this.dateOfBirth = ((String) in.readValue((String.class.getClassLoader())));
        this.yearOfBirth = ((String) in.readValue((String.class.getClassLoader())));
        this.ancestry = ((String) in.readValue((String.class.getClassLoader())));
        this.eyeColour = ((String) in.readValue((String.class.getClassLoader())));
        this.hairColour = ((String) in.readValue((String.class.getClassLoader())));
        this.wand = ((Wand) in.readValue((Wand.class.getClassLoader())));
        this.patronus = ((String) in.readValue((String.class.getClassLoader())));
        this.hogwartsStudent = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.hogwartsStaff = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.actor = ((String) in.readValue((String.class.getClassLoader())));
        this.alive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CharacterInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAncestry() {
        return ancestry;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public Boolean getHogwartsStudent() {
        return hogwartsStudent;
    }

    public void setHogwartsStudent(Boolean hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public Boolean getHogwartsStaff() {
        return hogwartsStaff;
    }

    public void setHogwartsStaff(Boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(species);
        dest.writeValue(gender);
        dest.writeValue(house);
        dest.writeValue(dateOfBirth);
        dest.writeValue(yearOfBirth);
        dest.writeValue(ancestry);
        dest.writeValue(eyeColour);
        dest.writeValue(hairColour);
        dest.writeValue(wand);
        dest.writeValue(patronus);
        dest.writeValue(hogwartsStudent);
        dest.writeValue(hogwartsStaff);
        dest.writeValue(actor);
        dest.writeValue(alive);
        dest.writeValue(image);
    }

    public int describeContents() {
        return 0;
    }



}



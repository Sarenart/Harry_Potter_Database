package com.example.harrypotterdatabase.model.service;

import com.example.harrypotterdatabase.model.models.CharacterInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HogwartsService {

    public static final String GRYFFINDOR = "gryffindor";
    public static final String RAVENCLAW = "ravenclaw";
    public static final String HUFFLEPUFF = "hufflepuff";
    public static final String SLYTHERIN = "slytherin";

    @GET("characters")
    Call<List<CharacterInfo>> getCharacters();

    @GET("characters/students")
    Call<List<CharacterInfo>> getStudentCharacters();
    
    @GET("characters/staff")
    Call<List<CharacterInfo>> getStaffCharacters();

    @GET("characters/house/{house}")
    Call<List<CharacterInfo>> getCharactersByHouse(@Path("house") String house);

}

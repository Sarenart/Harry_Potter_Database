package com.example.harrypotterdatabase.model.service;

import com.example.harrypotterdatabase.model.CharacterInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HogwartsService {

    public static final String GRYFFINDOR = "gryffindor";
    public static final String RAVENCLAW = "ravenclaw";
    public static final String HUFFLEPUFF = "hufflepuff";
    public static final String SLYTHERIN = "slytherin";

    @GET("characters")
    Call<CharacterInfo> getCharacters();

    @GET("characters/students")
    Call<CharacterInfo> getStudentCharacters();

    @GET("characters/staff")
    Call<CharacterInfo> getStaffCharacters();

    @GET("characters/house/{house}")
    Call<CharacterInfo> getCharactersByHouse(@Path("house") String house);
    //TODO добавить параметр в вызов (Проверить работоспособность позже)


}

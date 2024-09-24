package com.edsondev26.androidapp.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/0e072058dec08ba1fcc2a213678955db/search/{name}")
    suspend fun getSuperHeroes(@Path("name") superHeroName: String):Response<SuperHeroDataResponse>

    @GET("api/0e072058dec08ba1fcc2a213678955db/{id}")
    suspend fun getSuperHeroDetail(@Path("id") superheroId: String):Response<SuperHeroDetailResponse>
}
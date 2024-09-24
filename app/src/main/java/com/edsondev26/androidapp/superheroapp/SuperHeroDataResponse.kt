package com.edsondev26.androidapp.superheroapp

import com.google.gson.annotations.SerializedName
import retrofit2.Response

data class SuperHeroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("resultsFor") val resultsFor: String,
    @SerializedName("results") val superheroes: List<SuperHeroItemResponse>
)

data class SuperHeroItemResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage: SuperHeroImageResponse
)

data class SuperHeroImageResponse(
    @SerializedName("url") val url: String
)
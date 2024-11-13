package br.com.mizaeldouglas.hearthstone_app.data.api

import retrofit2.http.GET

interface HeathstoneService {

    @GET("cards")
    suspend fun getCards()
}
package br.com.mizaeldouglas.hearthstone_app.data.api

import br.com.mizaeldouglas.hearthstone_app.data.dto.CardDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HeathstoneService {

//    https://omgvamp-hearthstone-v1.p.rapidapi.com/cards/sets/Naxxramas?locale=ptBR
    @GET("cards/sets/{set}")
    suspend fun getCards(@Path("set") set: String): Response<List<CardDTO>>
}
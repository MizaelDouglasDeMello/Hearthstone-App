package br.com.mizaeldouglas.hearthstone_app.data.repository

import android.util.Log
import br.com.mizaeldouglas.hearthstone_app.data.api.HeathstoneService
import br.com.mizaeldouglas.hearthstone_app.data.dto.CardDTO
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val heathStoneService: HeathstoneService
) : ICardRepository {
    override suspend fun getCards(): List<CardDTO> {
        val response = heathStoneService.getCards("Journey to Un'Goro")

        if (response.isSuccessful) {
            val listCards = response.body()
            if (listCards != null) {
                Log.i("getCards", "API returned ${listCards.size} cards")
                return listCards
            } else {
                Log.i("getCards", "API returned null body")
            }
        } else {
            Log.i("getCards", "API call failed: ${response.errorBody()?.string()}")
        }

        return emptyList()
    }
}
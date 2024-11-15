package br.com.mizaeldouglas.hearthstone_app.data.repository

import br.com.mizaeldouglas.hearthstone_app.data.dto.CardDTO

interface ICardRepository {

    suspend fun getCards(): List<CardDTO>
}
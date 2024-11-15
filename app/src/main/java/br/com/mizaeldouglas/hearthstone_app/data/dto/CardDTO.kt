package br.com.mizaeldouglas.hearthstone_app.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardDTO(
//    val artist: String,
    val attack: Int,
    val cardId: String,
    val cardSet: String,
//    val collectible: Boolean,
    val cost: Int,
//    val dbfId: Int,
    val flavor: String,
    val health: Int,
//    val howToGet: String? = null,
//    val howToGetGold: String,
    val img: String,
//    val locale: String,
    val name: String,
//    val playerClass: String,
//    val rarity: String,
//    val text: String,
    val type: String
): Parcelable
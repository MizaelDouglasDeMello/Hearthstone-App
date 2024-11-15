package br.com.mizaeldouglas.hearthstone_app.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardDTO(
    val attack: Int,
    val cardId: String,
    val cardSet: String,
    val cost: Int,
    val flavor: String,
    val health: Int,
    val img: String,
    val name: String,
    val type: String
): Parcelable
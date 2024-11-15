package br.com.mizaeldouglas.hearthstone_app.prensentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mizaeldouglas.hearthstone_app.data.dto.CardDTO
import br.com.mizaeldouglas.hearthstone_app.data.repository.ICardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(
    private val cardRepository: ICardRepository
) : ViewModel() {

    private val _listCards = MutableLiveData<List<CardDTO>>()
    val listCards: LiveData<List<CardDTO>> get() = _listCards

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun getCards() {
        _isLoading.value = true
        viewModelScope.launch {
            val cards = cardRepository.getCards()
            val filteredCards = cards.filter { !it.img.isNullOrEmpty() }
            _listCards.postValue(filteredCards)
            _isLoading.value = false
        }
    }
}
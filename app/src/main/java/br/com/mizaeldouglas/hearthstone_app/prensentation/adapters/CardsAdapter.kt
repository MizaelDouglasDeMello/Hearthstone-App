package br.com.mizaeldouglas.hearthstone_app.prensentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mizaeldouglas.hearthstone_app.data.dto.CardDTO
import br.com.mizaeldouglas.hearthstone_app.databinding.ItemRvCardBinding
import com.squareup.picasso.Picasso

class CardsAdapter(
    private val onClick: (CardDTO) -> Unit
) : RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {
    private var cardList = emptyList<CardDTO>()

    fun updateData(newCardList: List<CardDTO>){
        cardList = newCardList
        notifyDataSetChanged()
    }

    inner class CardViewHolder(private val binding: ItemRvCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cardDTO: CardDTO) {
            binding.txtName.text = cardDTO.name
            binding.clItemCard.setOnClickListener {
                onClick(cardDTO)
            }

            Picasso.get()
                .load(cardDTO.img)
                .into(binding.imgCard)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =  ItemRvCardBinding.inflate(layoutInflater, parent, false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cardList[position])
    }
}
package br.com.mizaeldouglas.hearthstone_app.prensentation.activities

import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.mizaeldouglas.hearthstone_app.R
import br.com.mizaeldouglas.hearthstone_app.data.dto.CardDTO
import br.com.mizaeldouglas.hearthstone_app.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso


class DetailsActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getDetailsCard()

    }

    private fun getDetailsCard() {
        val bundle = intent.extras
        val card = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle?.getParcelable("card", CardDTO::class.java)
        } else {
            bundle?.getParcelable("card")
        }


        Picasso.get().load(card?.img).into(binding.imgCardDetails)
        binding.txtNameDatails.text = card?.name ?: ""
        binding.txtCardId.text = card?.cardId ?: ""
        binding.txtCardSet.text = card?.cardSet ?: ""
        binding.txtHealth.text = card?.health.toString() ?: ""
        binding.txtAttack.text = card?.attack.toString() ?: ""
        binding.txtCost.text = card?.cost.toString() ?: ""
        binding.txtType.text = card?.type ?: ""
        binding.txtFlavor.text = card?.flavor ?: ""

    }
}
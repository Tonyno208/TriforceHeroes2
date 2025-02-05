package com.example.triforceheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.triforceheroes.databinding.ItemGameBinding

class GameViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_game, parent, false)) {

    val binding = ItemGameBinding.bind(itemView)

    fun render(game: Game, onClickListener: (Game) -> Unit) {
        binding.tvGameTitle.text = game.title
        binding.tvGameYear.text = game.releaseYear
        binding.tvGamePlatform.text = game.platform
        Glide.with(binding.ivGameImage.context).load(game.imagen).into(binding.ivGameImage)

        binding.root.setOnClickListener { onClickListener(game) }

        binding.tvGameTitle.typeface =
            ResourcesCompat.getFont(binding.root.context, R.font.zelda)
        binding.tvGameYear.typeface =
            ResourcesCompat.getFont(binding.root.context, R.font.zelda)
        binding.tvGamePlatform.typeface =
            ResourcesCompat.getFont(binding.root.context, R.font.zelda)
    }
}

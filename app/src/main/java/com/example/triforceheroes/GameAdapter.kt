package com.example.triforceheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(
    private val gameList: List<Game>,
    private val onClickListener: (Game) -> Unit,
) : RecyclerView.Adapter<GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GameViewHolder(layoutInflater, parent)
    }

    override fun getItemCount(): Int = gameList.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val item = gameList[position]
        holder.render(item, onClickListener)

        holder.binding.cbFav.isChecked = item.isFavorite

        holder.binding.cbFav.setOnCheckedChangeListener { _, isChecked ->
            item.isFavorite = isChecked
            if (isChecked) {
                GameProvider.favoriteGames.add(item)
                Toast.makeText(holder.itemView.context, "Añadido a favoritos", Toast.LENGTH_SHORT).show()
            } else {
                GameProvider.favoriteGames.remove(item)
                Toast.makeText(holder.itemView.context, "Quitado de favoritos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

package com.example.triforceheroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.triforceheroes.databinding.FragmentDetailItemBinding

class DetailItemFragment : Fragment() {

    private var _binding: FragmentDetailItemBinding? = null
    private val binding get() = _binding!!

    private val args: DetailItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.detail_item_list_title)

        rellenarDetalles(args.gameId)

        binding.tvDetailItemListTitle.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvTitleLabel.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvGameTitle.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvPlatformLabel.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvGamePlatform.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvYearLabel.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvGameYear.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvDescriptionLabel.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvGameDescription.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.zelda)
    }

    private fun rellenarDetalles(gameId: String) {
        val game = GameProvider.gameList.find { it.id == gameId }

        game?.let {
            Glide.with(this)
                .load(it.imagen)
                .into(binding.ivGameImage)

            binding.tvGameTitle.text = it.title
            binding.tvGamePlatform.text = it.platform
            binding.tvGameYear.text = it.releaseYear
            binding.tvGameDescription.text = it.description
            binding.cbFav.isChecked = it.isFavorite

            binding.cbFav.setOnCheckedChangeListener { _, isChecked ->
                it.isFavorite = isChecked
                if (isChecked) {
                    GameProvider.favoriteGames.add(it)
                    Toast.makeText(context, "Añadido a favoritos", Toast.LENGTH_SHORT).show()
                } else {
                    GameProvider.favoriteGames.remove(it)
                    Toast.makeText(context, "Quitado de favoritos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

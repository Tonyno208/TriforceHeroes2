package com.example.triforceheroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.triforceheroes.databinding.FragmentFavDetailItemBinding

class FavDetailItemFragment : Fragment() {

    private var _binding: FragmentFavDetailItemBinding? = null
    private val binding get() = _binding!!
    private val args: FavDetailItemFragmentArgs by navArgs()
    private lateinit var game: Game

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.detail_item_list_title)
        applyCustomFonts()
        cargarDetalles(args.gameId)

        binding.fabComment.setOnClickListener {
            showCommentDialog()
        }
    }

    private fun applyCustomFonts() {
        val typeface = ResourcesCompat.getFont(requireContext(), R.font.zelda)
        with(binding) {
            tvDetailItemListTitle.typeface = typeface
            tvTitulo1.typeface = typeface
            tvGameTitle.typeface = typeface
            tvTitulo2.typeface = typeface
            tvGamePlatform.typeface = typeface
            tvTitulo3.typeface = typeface
            tvGameYear.typeface = typeface
            tvTitulo4.typeface = typeface
            tvGameDescription.typeface = typeface
            tvUserComment.typeface = typeface
        }
    }

    private fun cargarDetalles(gameId: String) {
        game = GameProvider.favoriteGames.find { it.id == gameId } ?: run {
            Toast.makeText(requireContext(), "Juego no encontrado", Toast.LENGTH_SHORT).show()
            return
        }

        with(binding) {
            Glide.with(this@FavDetailItemFragment)
                .load(game.imagen)
                .centerCrop()
                .into(ivGameImage)

            tvGameTitle.text = game.title
            tvGamePlatform.text = game.platform
            tvGameYear.text = game.releaseYear
            tvGameDescription.text = game.description

            cbFav.isChecked = true
        }
    }


    private fun showCommentDialog() {
        val input = EditText(requireContext()).apply {
            setText(game.userNotes)
        }

        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.comment_title))
            .setView(input)
            .setPositiveButton(getString(R.string.save)) { dialog, _ ->
                game.userNotes = input.text.toString()
                binding.tvUserComment.text = if (game.userNotes.isNullOrEmpty()) getString(R.string.no_comments) else game.userNotes
                Toast.makeText(requireContext(), getString(R.string.comment_saved), Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ -> dialog.cancel() }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

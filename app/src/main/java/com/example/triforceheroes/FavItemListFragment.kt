package com.example.triforceheroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.triforceheroes.databinding.FragmentFavItemListBinding

class FavItemListFragment : Fragment() {

    private var _binding: FragmentFavItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.fav_item_list_title)

        iniciarRecyclerView()

        binding.tvFavItemListTitle.typeface =
            ResourcesCompat.getFont(requireContext(),R.font.zelda)
    }

    private fun iniciarRecyclerView() {
        binding.rvFavGames.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavGames.adapter = GameAdapter(GameProvider.favoriteGames) { game ->
            onItemSelected(game)
        }
    }

    private fun onItemSelected(game: Game) {
        val action = FavItemListFragmentDirections
            .actionFavItemListFragmentToFavDetailItemFragment(game.id)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

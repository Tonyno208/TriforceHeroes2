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
import com.example.triforceheroes.databinding.FragmentItemListBinding

class ItemListFragment : Fragment() {

    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.item_list_title)

        iniciarRecyclerView()

        binding.tvItemListTitle.typeface =
            ResourcesCompat.getFont(requireContext(), R.font.zelda)
    }

    private fun iniciarRecyclerView() {
        val manager = LinearLayoutManager(requireContext())
        binding.RVGames.layoutManager = manager
        binding.RVGames.adapter = GameAdapter(
            GameProvider.gameList,
            { game -> onItemSelected(game) },
        )
    }

    private fun onItemSelected(game: Game) {
        val action = ItemListFragmentDirections.actionItemListFragmentToDetailItemFragment(game.id)
        findNavController().navigate(action)
    }
}

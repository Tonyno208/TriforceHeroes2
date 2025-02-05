package com.example.triforceheroes

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.triforceheroes.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.main_menu_title)
        mostrarMensajeBienvenida()
        configurarBotones()
        aplicarFuentePersonalizada()
        setupMenu()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mostrarMensajeBienvenida() {
        val user = obtenerUsuario()
        val welcomeMessageTemplate = resources.getString(R.string.msg_menu_welcome)
        binding.tvWelcome.text = String.format(welcomeMessageTemplate, user)
    }

    private fun obtenerUsuario(): String {
        val sharedPreferences = requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE)
        return sharedPreferences.getString("user", "Héroe de Hyrule") ?: "Héroe de Hyrule"
    }

    private fun configurarBotones() {

        binding.cardFavorites.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToFavItemListFragment()
            findNavController().navigate(action)
        }

        binding.cardCatalog.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToItemListFragment()
            findNavController().navigate(action)
        }

        binding.btnLogout.setOnClickListener {
            cerrarSesion()
        }
    }

    private fun cerrarSesion() {
        val sharedPreferences = requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE)
        sharedPreferences.edit().remove("user").apply()

        findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToLoginFragment())

        Toast.makeText(requireContext(), getString(R.string.msg_logout_success), Toast.LENGTH_SHORT).show()
    }

    private fun aplicarFuentePersonalizada() {
        val font = ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvWelcome.typeface = font
        binding.tvFavorites.typeface = font
        binding.tvCatalog.typeface = font
        binding.btnLogout.typeface = font
    }

    private fun setupMenu() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.options_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.settings_menu -> {
                        findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToCreditFragment())
                        true
                    }
                    R.id.userInfo_menu -> {
                        findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToUserInfoFragment())
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}

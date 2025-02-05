package com.example.triforceheroes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.triforceheroes.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.user_info_title)

        mostrarDatosUsuario()

        binding.btnLogout.setOnClickListener {
            val sharedPreferences = requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE)
            sharedPreferences.edit().remove("user").apply()
            Toast.makeText(requireContext(), getString(R.string.msg_logout_success), Toast.LENGTH_SHORT).show()
            findNavController().navigate(UserInfoFragmentDirections.actionUserInfoFragmentToLoginFragment())
        }

        binding.btnReturn.setOnClickListener {
            findNavController().navigate(UserInfoFragmentDirections.actionUserInfoFragmentToMenuFragment())
        }

        val font = ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvUserInfoTitle.typeface = font
        binding.tvUserName.typeface = font
        binding.tvFavCount.typeface = font
        binding.btnLogout.typeface = font
        binding.btnReturn.typeface = font

        setDefaultUserLogo()

        binding.ivUserAvatar.setOnClickListener {
            val dialog = LogoSelectionDialogFragment()
            dialog.show(childFragmentManager, "LogoSelectionDialogFragment")
        }

        childFragmentManager.setFragmentResultListener("logo_selection", viewLifecycleOwner) { _, bundle ->
            val selectedLogo = bundle.getInt("selected_logo")
            val sharedPreferences = requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE)
            sharedPreferences.edit().putInt("user_logo", selectedLogo).apply()
            binding.ivUserAvatar.setImageResource(selectedLogo)
        }
    }

    private fun setDefaultUserLogo() {
        val sharedPreferences = requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE)
        val storedLogoId = sharedPreferences.getInt("user_logo", -1)

        val defaultLogos = listOf(
            R.drawable.logo_dark,
            R.drawable.logo_light,
            R.drawable.splash_logo
        )

        val logoToUse = if (storedLogoId != -1) {
            storedLogoId
        } else {
            defaultLogos.random().also { selected ->
                sharedPreferences.edit().putInt("user_logo", selected).apply()
            }
        }

        binding.ivUserAvatar.setImageResource(logoToUse)
    }

    private fun mostrarDatosUsuario() {
        val userName = obtenerUsuario()
        binding.tvUserName.text = getString(R.string.user_name, userName)

        val favoritosCount = obtenerFavoritos()
        binding.tvFavCount.text = when (favoritosCount) {
            0 -> getString(R.string.user_fav_count_0)
            1 -> getString(R.string.user_fav_count_1, favoritosCount)
            else -> getString(R.string.user_fav_count_n, favoritosCount)
        }
    }

    private fun obtenerUsuario(): String {
        val sharedPreferences = requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE)
        return sharedPreferences.getString("user", "Héroe de Hyrule") ?: "Héroe de Hyrule"
    }

    private fun obtenerFavoritos(): Int {
        return GameProvider.gameList.count { it.isFavorite }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

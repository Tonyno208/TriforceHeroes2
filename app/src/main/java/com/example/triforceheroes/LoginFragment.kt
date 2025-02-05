package com.example.triforceheroes

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.example.triforceheroes.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsuario.text.toString()
                .trim()
                .lowercase()
                .replaceFirstChar(Char::uppercase)

            if (username.isNotEmpty()) {
                val sharedPreferences = requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE)
                sharedPreferences.edit().putString("user", username).apply()

                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMenuFragment())
            } else {
                Toast.makeText(context, getString(R.string.error_empty_username), Toast.LENGTH_SHORT).show()
            }
        }

        binding.ivLogo.setOnClickListener {
            Toast.makeText(context, "Made by Antonio Rodríguez Díaz", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.login_title)

        val font = ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvWelcome.typeface = font
        binding.btnLogin.typeface = font
        binding.etUsuario.typeface = font
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

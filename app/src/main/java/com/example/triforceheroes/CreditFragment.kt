package com.example.triforceheroes

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.LocaleListCompat
import androidx.navigation.fragment.findNavController
import com.example.triforceheroes.databinding.FragmentCreditBinding

class CreditFragment : Fragment() {

    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.credit_title)

        setupNightMode()
        setupLanguageMode()
        setupContactSupport()

        binding.btnReturn.setOnClickListener {
            val action = CreditFragmentDirections.actionCreditFragmentToMenuFragment()
            findNavController().navigate(action)
        }

        val font = ResourcesCompat.getFont(requireContext(), R.font.zelda)
        binding.tvCreditTitle.typeface = font
        binding.tvLanguageEN.typeface = font
        binding.tvLanguageES.typeface = font
        binding.btnReturn.typeface = font
        binding.btnContactSupport.typeface = font
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupNightMode() {
        val modeSwitch = binding.switchDarkMode
        val sharedPreferences = activity?.getSharedPreferences("MODE", Context.MODE_PRIVATE)
        val nightMode = sharedPreferences?.getBoolean("NIGHT_MODE", false) ?: false

        modeSwitch.isChecked = nightMode

        modeSwitch.setOnCheckedChangeListener { _, isChecked ->
            AppCompatDelegate.setDefaultNightMode(
                if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
                else AppCompatDelegate.MODE_NIGHT_NO
            )

            sharedPreferences?.edit()?.putBoolean("NIGHT_MODE", isChecked)?.apply()
        }
    }

    private fun setupLanguageMode() {
        val languageSwitch = binding.switchLanguage
        val sharedPreferences = activity?.getSharedPreferences("MODE", Context.MODE_PRIVATE)
        val languagePreference = sharedPreferences?.getString("LANGUAGE", "en") ?: "en"

        languageSwitch.isChecked = languagePreference == "es"

        languageSwitch.setOnCheckedChangeListener { _, isChecked ->
            val newLanguage = if (isChecked) "es" else "en"

            val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags(newLanguage)
            AppCompatDelegate.setApplicationLocales(appLocale)

            sharedPreferences?.edit()?.putString("LANGUAGE", newLanguage)?.apply()
        }
    }

    private fun setupContactSupport() {
        binding.btnContactSupport.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:rodriguezdiazantonio04@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Soporte - Triforce Heroes")
                putExtra(Intent.EXTRA_TEXT, "Hola, necesito ayuda con...")
            }
            startActivity(Intent.createChooser(emailIntent, "Enviar correo"))
        }
    }
}

package com.example.triforceheroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult

class LogoSelectionDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_logo_selection, container, false)

        view.findViewById<ImageView>(R.id.ivLogoDark).setOnClickListener {
            onLogoSelected(R.drawable.imagen1)
        }

        view.findViewById<ImageView>(R.id.ivLogoLight).setOnClickListener {
            onLogoSelected(R.drawable.imagen2)
        }

        view.findViewById<ImageView>(R.id.ivLogoDefault).setOnClickListener {
            onLogoSelected(R.drawable.imagen3)
        }

        return view
    }

    private fun onLogoSelected(logoResId: Int) {
        setFragmentResult("logo_selection", Bundle().apply {
            putInt("selected_logo", logoResId)
        })
        dismiss()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
    }
}

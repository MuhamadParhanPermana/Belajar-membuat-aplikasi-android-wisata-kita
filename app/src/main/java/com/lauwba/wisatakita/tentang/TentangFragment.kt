package com.lauwba.wisatakita.tentang

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import com.lauwba.wisatakita.R
import com.lauwba.wisatakita.databinding.FragmentTentangBinding

class TentangFragment : Fragment() {
    private var _binding: FragmentTentangBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTentangBinding.inflate(inflater, container,false)
        return binding.root
    }

    fun openBrowser(url: String?) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()

        customTabsIntent.launchUrl(requireContext(), Uri.parse(url))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.binding.facebook.setOnClickListener {
            this.openBrowser("https://fb.me/Muhamad Parhan Permana")
        }
        this.binding.telegram.setOnClickListener {
            this.openBrowser("https://t.me/MHDFRHNPRMN")
        }
        this.binding.instagram.setOnClickListener {
            this.openBrowser("https://instagram.com/farhan.pmn")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
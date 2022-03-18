package com.lauwba.wisatakita.portal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.lauwba.wisatakita.databinding.FragmentPortalBinding

class PortalFragment : Fragment() {
    private var _binding: FragmentPortalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPortalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //inisialisasi
        binding.portalWeb.settings.javaScriptEnabled = true
        binding.portalWeb.settings.builtInZoomControls = true

        //pasang webchrome clientnya
        binding.portalWeb.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                //kasih progress ke progress bar nya
                binding.progressBar.progress = newProgress
            }
        }
        binding.portalWeb.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                //sembunyikan progressbarnya kalau halamanya udah selesai diload
                binding.progressBar.visibility = View.GONE
            }
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
        binding.portalWeb.loadUrl("https://google.com")
    }
}
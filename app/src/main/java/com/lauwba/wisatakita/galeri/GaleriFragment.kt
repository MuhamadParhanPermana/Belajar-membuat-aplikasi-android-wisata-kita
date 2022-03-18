package com.lauwba.wisatakita.galeri

import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.lauwba.wisatakita.R
import com.lauwba.wisatakita.databinding.FragmentGaleriBinding

class GaleriFragment : Fragment() {
    private val url = arrayOf(
        "https://cdns.klimg.com/merdeka.com/i/w/news/2018/05/21/978617/content_images/670x335/20180521113239-2-trans-studio-mini-maguwo-001-tantri-setyorini.jpg",
        "https://cdns.klimg.com/merdeka.com/i/w/news/2018/05/21/978617/content_images/670x335/20180521113239-1-the-world-landmarks-merapi-park-001-tantri-setyorini.jpg",
        "https://cdns.klimg.com/merdeka.com/i/w/news/2018/05/21/978617/content_images/670x335/20180521113239-3-pantai-nglambor-001-tantri-setyorini.jpg",
        "https://cdns.klimg.com/merdeka.com/i/w/news/2018/05/21/978617/content_images/670x335/20180521113240-4-jogja-bay-waterpark-001-tantri-setyorini.jpg",
        "https://cdns.klimg.com/merdeka.com/i/w/news/2018/05/21/978617/content_images/670x335/20180521113240-5-kebun-teh-nglinggo-001-tantri-setyorini.jpg",
        "https://lh3.googleusercontent.com/proxy/XwMFvRht_5LJy2nHRXPZ_pz_SCWTlLh1BBgEs1v0ZAjjuxOIYBmTRqh0mK45UWxEC8ug13F8ks9g3RaH7KMY_XsibDrMBpVaSy_j0uzi6qf9QXoXH8EU4hrR6zCKuoK6W9oHjG_Yx0L_qIOuek0_LzXpd1AmaJw=w1000-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipMEosqiOfvW7aB8GROmk874_HfLhwhT_z1RphPi=w1000-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipNzTZjNeln6WUrc1sWklEZCGMRQhDyU3jxHY0uw=s677-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipPsmfiRY32YKp80kaA-OMq8E8u9agDh9ZnUcDtq=w1000-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipMYljwO4dYe4vIo27L0JrWoOlILu8UfWjnzLzYr=w1000-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipNkQJXDmUSTnJ0kv5XJgskvrUgJollFT4UkyhYD=w1000-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipPhIc06sZYJIp423XjsgxdQEJv5X5mgEouJ2LHf=w1000-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipPknoGMr9y7h_ALXLkQZj1i9UsJU0o2O-tazF3R=w1156-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipPA2P3xj2NgPsA20qrcZ4DUR0wynFDkVXK6txTg=w1156-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipNzLkzvZR9REtZNT_god-NAXlN5nLojMpGKny73=w1150-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipM2xZoOLys8P6KdlnXA2jTqyNba5_A13ylCAbnB=w1150-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipO5H-Qb-Eh25PAF4f_8a0nGETqMtQvMVPnQJO-w=w1150-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipOiNuhhoRifZTVDuPha9QxigQb-CFXP0AEAZMeb=w1156-h780-k-no",
        "https://lh5.googleusercontent.com/p/AF1QipNbnCnj1y_ZPaF188N9a0oXgleAaHk6v6TtM0Vh=w1150-h780-k-no"
    )

    private var _binding: FragmentGaleriBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGaleriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = GaleriAdapter(url) { images, position ->
            StfalconImageViewer.Builder<String>(requireContext(), images) { imageView, image ->
                Glide.with(requireActivity())
                    .load(image)
                    .into(imageView)
            }.withStartPosition(position).show(true)
        }
        binding.imageList.adapter = adapter
        val lm = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.imageList.layoutManager = lm
        binding.imageList.itemAnimator = DefaultItemAnimator()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.lauwba.wisatakita.destinasi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.android.gms.maps.model.LatLng
import com.lauwba.wisatakita.databinding.FragmentDestinasiBinding
import kotlin.math.abs

class DestinasiFragment : Fragment() {
    private var _binding: FragmentDestinasiBinding? = null
    private val binding get() = _binding!!
    private val destinationImage = arrayListOf(
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
    private val destinationName = arrayListOf(
        "Candi Prambanan",
        "Taman Sari",
        "Tugu Jogja",
        "Taman Nasional Gunung Merapi",
        "Yogyakarta International Airport",
        "Pantai Parangtritis",
        "Air Terjun Sri Gethuk",
        "Pantai Indrayanti",
        "Pantai Pok Tunggal",
        "Jl. Malioboro",
        "Pasar Beringharjo",
        "Ratu Boko",
        "Kebun Buah Mangunan",
        "Hutan Mangrove Wana Tirta"
    )

    private val destinationLocation = arrayListOf(
        "Sleman",
        "Kota Yogyakarta",
        "Kota Yogyakarta",
        "Sleman",
        "Kulon Progo",
        "Bantul",
        "Gunung Kidul",
        "Gunung Kidul",
        "Gunung Kidul",
        "Kota Yogyakarta",
        "Kota Yogyakarta",
        "Sleman",
        "Bantul",
        "Kulon Progo"
    )

    private val destinationLatLng = arrayListOf(
        LatLng(-7.7520211, 110.4925099),
        LatLng(-7.809798, 110.359054),
        LatLng(-7.7828609, 110.3583181),
        LatLng(-7.5407175, 110.4457241),
        LatLng(-7.900302, 110.0569203),
        LatLng(-8.0261393, 110.3351046),
        LatLng(-7.9428521, 110.4871372),
        LatLng(-8.1507833, 110.6103773),
        LatLng(-8.1554992, 110.6128602),
        LatLng(-7.7926306, 110.3658442),
        LatLng(-7.798789, 110.3652543),
        LatLng(-7.7705363, 110.487227),
        LatLng(-7.9413665, 110.4225458),
        LatLng(-7.89485, 110.0209858)
    )
    private val destinationRating = arrayListOf(
        4.5,
        4.6,
        4.8,
        4.4,
        4.6,
        4.5,
        4.4,
        4.5,
        4.6,
        4.7,
        4.5,
        4.6,
        4.6,
        4.1
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDestinasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //preparing daftar destinasi
        val listDestinasi = arrayListOf<Destinasi>()

        //looping tiap element untuk destination image
        destinationImage.mapIndexed { index, s ->
            val destinasi = Destinasi(
                destinationName[index],
                destinationRating[index],
                s,
                destinationLatLng[index],
                destinationLocation[index]
            )
            listDestinasi.add(destinasi)
        }

        val adapter = DestinasiAdapter(listDestinasi) {
            val mapsViewActivity = Intent(requireActivity(), MapsViewActivity::class.java)
            mapsViewActivity.putExtra("lat", it.coordinate.latitude)
            mapsViewActivity.putExtra("lng", it.coordinate.longitude)
            mapsViewActivity.putExtra("destinationName", it.namaDestinasi)
            startActivity(mapsViewActivity)
        }

        binding.viewPagerSlider.adapter = adapter
        binding.viewPagerSlider.clipToPadding = false
        binding.viewPagerSlider.clipChildren = false
        binding.viewPagerSlider.offscreenPageLimit  = 3
        binding.viewPagerSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(20))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }

        binding.viewPagerSlider.setPageTransformer(compositePageTransformer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
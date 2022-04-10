package com.example.homework17.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework17.databinding.FragmentMainBinding
import com.example.homework17.utils.navigateToFragment

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    private val listOfPictures = listOf(
        "https://bugaga.ru/uploads/posts/2017-03/1489051999_kotik-hosiko-23.jpg",
        "https://funik.ru/wp-content/uploads/2018/10/da28f94947566ebdc387.jpg",
        "https://i01.fotocdn.net/s115/42eac822a3b5285c/public_pin_l/2599743304.jpg",
        "https://proprikol.ru/wp-content/uploads/2019/08/kartinki-nyashnye-kotiki-15.jpg",
        "https://postila.ru/data/c4/8e/b8/de/c48eb8de2454aa3f04f4b5b9cf87ee93685962b9fa329b2ddf0f9f01df52d2df.jpg",
        "https://bugaga.ru/uploads/posts/2017-03/1489052030_kotik-hosiko-12.jpg"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setListeners()
    }

    private fun setListeners() {
        binding?.btnGoToFragmentWithPicture?.setOnClickListener {
            val bundle = Bundle()
            val fragment = PictureGlideFragment()
            bundle.putString("PICTURE_GLIDE_EXTRA_KEY", listOfPictures.random().toString())
            fragment.arguments = bundle
            requireActivity().navigateToFragment(fragment, addToBackStack = true)
        }
    }
}
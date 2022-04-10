package com.example.homework17.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homework17.R
import kotlinx.android.synthetic.main.fragment_picture_glide.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PictureGlideFragment : Fragment(R.layout.fragment_picture_glide) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        CoroutineScope(Dispatchers.Main).launch {
            loadImageFromNetwork(
                imageUrl = arguments?.getString("PICTURE_GLIDE_EXTRA_KEY").toString(),
                imageView = ivPicture
            )
        }
    }

    suspend fun loadImageFromNetwork(imageUrl: String, imageView: ImageView) {
        Glide.with(requireContext())
            .load(imageUrl)
            .into(imageView)

    }
}
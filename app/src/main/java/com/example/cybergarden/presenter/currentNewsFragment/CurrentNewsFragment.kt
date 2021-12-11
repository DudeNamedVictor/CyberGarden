package com.example.cybergarden.presenter.currentNewsFragment

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.cybergarden.R
import com.example.cybergarden.data.News
import com.example.cybergarden.databinding.CurrentNewsLayoutBinding
import java.util.*

class CurrentNewsFragment : Fragment() {

    private lateinit var binding: CurrentNewsLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CurrentNewsLayoutBinding.inflate(inflater, container, false)
        binding.toolbar.apply {
            toolbarTitle.setText(R.string.events)
            back.visibility = View.VISIBLE
            back.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = arguments?.getParcelable<News>(NEWS_KEY)

        binding.apply {
            title.text = arguments?.title
            description.text = arguments?.description
            date.text = arguments?.data
            val imageBytes = Base64.getDecoder().decode(arguments?.image)
            val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size);
            image.load(bitmap)
        }

    }

    companion object {
        const val NEWS_KEY = "NEWS_KEY"
    }

}
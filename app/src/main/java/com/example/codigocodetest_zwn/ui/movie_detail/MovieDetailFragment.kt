package com.example.codigocodetest_zwn.ui.movie_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codigocodetest_zwn.databinding.FragmentMovieDetailBinding
import com.example.codigocodetest_zwn.model.MovieModel
import com.example.codigocodetest_zwn.utilities.popBackStack
import com.example.codigocodetest_zwn.utilities.setGlide

class MovieDetailFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailBinding

    private fun initViewBinding() {
        binding = FragmentMovieDetailBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arguments?.let {
            val movie = it.getSerializable("movie") as MovieModel
            binding.apply {
                ivPoster.clipToOutline = true
                ivPoster.setGlide(movie.poster_path)
                tvMovieName.text = movie.original_title
                tvReleaseDate.text = movie.release_date
                tvMovieDesc.text = movie.overview
            }
        }

        binding.ivBack.setOnClickListener {
            it.popBackStack()
        }

        return binding.root
    }
}
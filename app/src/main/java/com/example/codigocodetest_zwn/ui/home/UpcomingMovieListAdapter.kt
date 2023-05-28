package com.example.codigocodetest_zwn.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codigocodetest_zwn.databinding.LayoutUpcomingMovieItemBinding
import com.example.codigocodetest_zwn.model.MovieModel
import com.example.codigocodetest_zwn.utilities.setGlide

class UpcomingMovieListAdapter : RecyclerView.Adapter<UpcomingMovieListAdapter.ViewHolder>() {
    private var movieList: List<MovieModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutUpcomingMovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(movieList: List<MovieModel>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(movieList[position])
    }

    class ViewHolder(private val binding: LayoutUpcomingMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: MovieModel) {
            binding.apply {
                ivPoster.setGlide(data.poster_path)
                tvMovieName.text = data.original_title
                tvOverview.text = data.overview
            }
        }
    }
}
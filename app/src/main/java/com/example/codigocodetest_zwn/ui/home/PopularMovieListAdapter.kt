package com.example.codigocodetest_zwn.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codigocodetest_zwn.databinding.LayoutPopularMovieItemBinding
import com.example.codigocodetest_zwn.model.MovieModel
import com.example.codigocodetest_zwn.utilities.setGlide

class PopularMovieListAdapter : RecyclerView.Adapter<PopularMovieListAdapter.ViewHolder>() {
    private var movieList: List<MovieModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutPopularMovieItemBinding.inflate(
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

    class ViewHolder(private val binding: LayoutPopularMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: MovieModel) {
            binding.apply {
                ivPoster.setGlide(data.poster_path)
                tvTitle.text = data.original_title
                tvTitle.isSelected = true
            }
        }
    }
}
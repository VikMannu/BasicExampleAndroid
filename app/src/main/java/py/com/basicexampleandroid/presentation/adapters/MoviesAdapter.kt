package py.com.basicexampleandroid.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import py.com.basicexampleandroid.databinding.ViewHolderMovieItemBinding
import py.com.basicexampleandroid.domain.model.MovieModel

class MoviesAdapter(
    private val movies: List<MovieModel>,
    private val onMovieClick: (MovieModel) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(
        private val binding: ViewHolderMovieItemBinding
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(movie: MovieModel) {
            binding.tvTitle.text = movie.title
            binding.tvRating.text = movie.rating.toString()
        }

        override fun onClick(p0: View?) {
            onMovieClick(movies[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ViewHolderMovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }
}
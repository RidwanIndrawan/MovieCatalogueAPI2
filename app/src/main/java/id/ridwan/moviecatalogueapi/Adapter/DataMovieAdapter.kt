package id.ridwan.moviecatalogueapi.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ridwan.moviecatalogueapi.BuildConfig
import id.ridwan.moviecatalogueapi.DataMaster.DataMovies
import id.ridwan.moviecatalogueapi.R
import kotlinx.android.synthetic.main.item_row_movie.view.*
import kotlinx.android.synthetic.main.item_row_tv.view.*

class DataMovieAdapter(private val listMovie : ArrayList<DataMovies>) : RecyclerView.Adapter<DataMovieAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(movie : DataMovies){
            with(itemView){
                Glide.with(itemView.context)
                    .load("${BuildConfig.IMAGE_URL}t/p/w185${movie.poster}")
                    .into(itemView.posterMV)
                titleTextMV.text = movie.title
                dateTextMV.text = movie.date
                voteTextMV.text = movie.vote.toString()
            }
        }
    }
}
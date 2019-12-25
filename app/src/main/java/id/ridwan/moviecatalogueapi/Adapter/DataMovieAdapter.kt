package id.ridwan.moviecatalogueapi.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ridwan.moviecatalogueapi.BuildConfig
import id.ridwan.moviecatalogueapi.DataMaster.DataMaster
import id.ridwan.moviecatalogueapi.R
import kotlinx.android.synthetic.main.item_row_movie.view.*

class DataMovieAdapter(private val listMovie : ArrayList<DataMaster>) : RecyclerView.Adapter<DataMovieAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(movie : DataMaster){
            with(itemView){
                Glide.with(itemView.context)
                    .load("${BuildConfig.IMAGE_URL}t/p/w185${movie.poster}")
                    .into(itemView.posterMV)
                titleTextMV.text = movie.title
                dateTextMV.text = movie.date
                statusTextMV.text = movie.status
            }
        }
    }

    fun checkMovie(movies : ArrayList<DataMaster>){
        listMovie.clear()
        listMovie.addAll(movies)
        notifyDataSetChanged()
    }

    fun addMovies(movies : ArrayList<DataMaster>){
        listMovie.addAll(movies)
        notifyDataSetChanged()
    }
}
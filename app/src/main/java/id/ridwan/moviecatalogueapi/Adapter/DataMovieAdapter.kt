package id.ridwan.moviecatalogueapi.Adapter

import android.content.Context
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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataMovieAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val list = ArrayList<DataMaster>()


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
}
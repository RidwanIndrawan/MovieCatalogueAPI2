package id.ridwan.moviecatalogueapi.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ridwan.moviecatalogueapi.BuildConfig
import id.ridwan.moviecatalogueapi.DataMaster.DataTVShows
import id.ridwan.moviecatalogueapi.Interface.DetailTVShow
import id.ridwan.moviecatalogueapi.R
import kotlinx.android.synthetic.main.item_row_tv.view.*

class DataTVShowAdapter (private val listTVShow : ArrayList<DataTVShows>) : RecyclerView.Adapter<DataTVShowAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_tv,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listTVShow.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listTVShow[position])
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(tvshow : DataTVShows){
            with(itemView){
                Glide.with(itemView.context)
                    .load("${BuildConfig.IMAGE_URL}t/p/w185${tvshow.poster}")
                    .into(itemView.posterTV)
                titleTextTV.text = tvshow.title
                firstepisodeTV.text = tvshow.datefirst
                voteTextTV.text = tvshow.vote.toString()

                itemView.setOnClickListener{
                    Toast.makeText(itemView.context, tvshow.title,Toast.LENGTH_LONG).show()

                    val intent = Intent(itemView.context,DetailTVShow::class.java)

                    intent.putExtra(DetailTVShow.KEY_TV, tvshow)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }


}
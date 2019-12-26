package id.ridwan.moviecatalogueapi.Interface


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ridwan.moviecatalogueapi.Adapter.DataMovieAdapter
import id.ridwan.moviecatalogueapi.Adapter.DataTVShowAdapter
import id.ridwan.moviecatalogueapi.R
import id.ridwan.moviecatalogueapi.ViewModel.MovieViewModel
import id.ridwan.moviecatalogueapi.ViewModel.TVShowViewModel
import kotlinx.android.synthetic.main.fragment_movie.view.*
import kotlinx.android.synthetic.main.fragment_tvshow.view.*

/**
 * A simple [Fragment] subclass.
 */
class TVShow : Fragment() {

    private lateinit var tvShowViewModel: TVShowViewModel
    private lateinit var tvShowViewer : View

    private var page = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tvShowViewer = inflater.inflate(R.layout.fragment_tvshow, container, false)

        tvShowViewer.tvshows.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        tvShowViewModel = ViewModelProviders.of(this).get(TVShowViewModel::class.java)
        tvShowViewModel.setTVShow(resources.getString(R.string.language_code), page)
        tvShowViewModel.getTVShows().observe(this, Observer { tvshow ->
            if(tvshow == null){
                Toast.makeText(context,resources.getString(R.string.check_your_connection), Toast.LENGTH_LONG).show()

            }
            else { tvShowViewer.tvshows.adapter = DataTVShowAdapter(tvshow) }
        })
        return tvShowViewer
    }
}

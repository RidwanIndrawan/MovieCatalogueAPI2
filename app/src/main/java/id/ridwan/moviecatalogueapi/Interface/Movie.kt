package id.ridwan.moviecatalogueapi.Interface


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ridwan.moviecatalogueapi.Adapter.DataMovieAdapter
import id.ridwan.moviecatalogueapi.R
import id.ridwan.moviecatalogueapi.ViewModel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_movie.view.*

/**
 * A simple [Fragment] subclass.
 */
class Movie : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var moviewViewer: View

    private var page = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        moviewViewer = inflater.inflate(R.layout.fragment_movie, container, false)
        moviewViewer.movies.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movieViewModel.setMovie(resources.getString(R.string.language_code), page)
        movieViewModel.getMovies().observe(this, Observer { movie ->
            showLoading(true)
            if(movie == null){
                Toast.makeText(context,resources.getString(R.string.check_your_connection),Toast.LENGTH_LONG).show()
            }
            else {
                showLoading(false)
                moviewViewer.movies.adapter = DataMovieAdapter(movie) }
            })
        return moviewViewer
    }

    private fun showLoading(state:Boolean){
        if(state){
            progressBar.visibility = View.VISIBLE
        }else{
            progressBar.visibility = View.GONE
        }
    }
}




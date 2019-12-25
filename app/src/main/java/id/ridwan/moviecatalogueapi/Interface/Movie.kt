package id.ridwan.moviecatalogueapi.Interface


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ridwan.moviecatalogueapi.Adapter.DataMovieAdapter
import id.ridwan.moviecatalogueapi.R
import id.ridwan.moviecatalogueapi.ViewModel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.view.*

/**
 * A simple [Fragment] subclass.
 */
class Movie : Fragment() {

    //    private lateinit var movies : ArrayList<DataMaster>
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var moviewViewer: View
        private lateinit var dataMovieAdapter : DataMovieAdapter
    private var page = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        moviewViewer = inflater.inflate(R.layout.fragment_movie, container, false)

//        dataMovieAdapter = DataMovieAdapter(movies)

        moviewViewer.movies.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movieViewModel.setMovie(resources.getString(R.string.language_code), page)
        movieViewModel.getMovies().observe(this, Observer { movie ->
            moviewViewer.refreshLayout.setOnRefreshListener {
                if (movie != null) {
                    if (page == 1) {
                        dataMovieAdapter.checkMovie(movie)
                    } else {
                        dataMovieAdapter.addMovies(movie)
                    }
                } else {
                    Toast.makeText(
                        context,
                        resources.getString(R.string.check_your_connection),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }})


        return moviewViewer
    }

//    private val checkMovies = Observer<ArrayList<DataMaster>>{
//        moviee -> this.movies = moviee
//        moviewViewer.refreshLayout.finishRefresh(true)
//        moviewViewer.refreshLayout.finishLoadMore(true)
//        if(moviee != null){
//            if(page == 1){
//                dataMovieAdapter.checkMovie(moviee)
//            } else {
//                dataMovieAdapter.addMovies(moviee)
//            }
//        } else {
//            Toast.makeText(context, resources.getString(R.string.check_your_connection), Toast.LENGTH_LONG).show()
//        }
//    }
}




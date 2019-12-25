package id.ridwan.moviecatalogueapi.Interface


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import id.ridwan.moviecatalogueapi.R
import id.ridwan.moviecatalogueapi.ViewModel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.view.*

/**
 * A simple [Fragment] subclass.
 */
class Movie : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var moviewViewer : View
    private var page = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        moviewViewer = inflater.inflate(R.layout.fragment_movie,container,false)

        moviewViewer.movies.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movieViewModel.setMovie(resources.getString(R.string.language_code),page)

        moviewViewer.refreshLayout.setOnRefreshListener(object : OnRefreshLoadMoreListener{
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                page += 1
                movieViewModel.setMovie(resources.getString(R.string.language_code), page)
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                page = 1
                movieViewModel.setMovie(resources.getString(R.string.language_code),page)
            }
        })
    return moviewViewer
    }
}




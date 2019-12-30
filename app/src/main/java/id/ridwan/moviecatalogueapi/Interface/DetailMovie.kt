package id.ridwan.moviecatalogueapi.Interface

import kotlin.concurrent.schedule
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import id.ridwan.moviecatalogueapi.BuildConfig
import id.ridwan.moviecatalogueapi.DataMaster.DataMovies
import id.ridwan.moviecatalogueapi.R
import id.ridwan.moviecatalogueapi.ViewModel.MovieDetailViewModel
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movie.*

class DetailMovie : AppCompatActivity() {

    companion object{
        const val KEY = "key"
    }

    private lateinit var movieDetailViewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        backButton()

        val dataMovie = intent.getParcelableExtra<DataMovies>(KEY)
        Glide.with(this)
            .load("${BuildConfig.IMAGE_URL}t/p/w500${dataMovie.poster}")
            .into(posterDetailMV)
        titleDetailMV.text = dataMovie.title
        dateDetailMV.text = dataMovie.date
        ratingDetailMV.text = dataMovie.vote.toString()

        movieDetailViewModel = ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)
        movieDetailViewModel.setMovie(dataMovie.id,resources.getString(R.string.language_code))
        movieDetailViewModel.getDetailMovie()?.observe(this, Observer { detailMovie ->
            showLoading(true)
            if(detailMovie == null){
                Toast.makeText(this,resources.getString(R.string.check_your_connection),Toast.LENGTH_LONG).show()
            }else{
//                loading akan terus berjalan sampai data selesai dimuat
//                dari web, bahasa indonesia untuk overview memang kosong
            overviewDetail.text = detailMovie.overview
            statusDetailMV.text = detailMovie.status
            runtimeDetailMV.text = detailMovie.runtime.toString()
            Glide.with(this)
                .load("${BuildConfig.IMAGE_URL}t/p/original${detailMovie.backdrop}")
                .into(backPosterMV)
                showLoading(false)
            }
        })
    }

    private fun showLoading(state:Boolean){
        if(state){
            progressBarDetail.visibility = View.VISIBLE
        }else{
            progressBarDetail.visibility = View.GONE
        }
    }

    private fun backButton(){
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        setSupportActionBar(toolbarMV)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp)
        toolbarMV.setNavigationOnClickListener {
            finish()
        }
    }
}



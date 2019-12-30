package id.ridwan.moviecatalogueapi.Interface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import id.ridwan.moviecatalogueapi.BuildConfig
import id.ridwan.moviecatalogueapi.DataMaster.DataTVShows
import id.ridwan.moviecatalogueapi.R
import id.ridwan.moviecatalogueapi.ViewModel.TVShowDetailViewModel
import kotlinx.android.synthetic.main.activity_detail_tvshow.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailTVShow : AppCompatActivity() {

    companion object{
        const val KEY_TV = "key_tv"
    }

    private lateinit var tvShowDetailViewModel : TVShowDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tvshow)

        backButton()

        val dataTVShow = intent.getParcelableExtra<DataTVShows>(KEY_TV)
        Glide.with(this)
            .load("${BuildConfig.IMAGE_URL}t/p/w500${dataTVShow.poster}")
            .into(posterDetailTV)
        titleDetailTV.text = dataTVShow.title
        dateDetailTV.text = dataTVShow.datefirst
        ratingDetailTV.text = dataTVShow.vote.toString()

        tvShowDetailViewModel = ViewModelProviders.of(this).get(TVShowDetailViewModel::class.java)
        tvShowDetailViewModel.setTVShow(dataTVShow.id,resources.getString(R.string.language_code))
        tvShowDetailViewModel.getDetailTVShow()?.observe(this, Observer { detailTVShow ->
            showLoading(true)
            if(detailTVShow == null){
                Toast.makeText(this, resources.getString(R.string.check_your_connection),Toast.LENGTH_LONG).show()
            }else{
                overviewDetailTV.text = detailTVShow.overview
                statusDetailTV.text = detailTVShow.status
                seasonDetailTV.text =detailTVShow.seasons
                episodesDetailTV.text = detailTVShow.episodes
                Glide.with(this)
                    .load("${BuildConfig.IMAGE_URL}t/p/original${detailTVShow.backdrop}")
                    .into(backPosterTV)
                showLoading(false)
            }
        })
    }
    private fun showLoading(state:Boolean){
        if(state){
            progressBarDetailTV.visibility = View.VISIBLE
        }else{
            progressBarDetailTV.visibility = View.GONE
        }
    }

    private fun backButton(){
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        setSupportActionBar(toolbarTV)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp)
        toolbarTV.setNavigationOnClickListener {
            finish()
        }
    }
}

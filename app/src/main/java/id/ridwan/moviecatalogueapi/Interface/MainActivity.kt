package id.ridwan.moviecatalogueapi.Interface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import id.ridwan.moviecatalogueapi.Adapter.TabAdapter
import id.ridwan.moviecatalogueapi.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var tabAdapter : TabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupViewPager(view_pager)
        tabs.setupWithViewPager(view_pager)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setSupportActionBar(toolbar)
        supportActionBar?.elevation = 0f
    }

    private fun setupViewPager(viewPager: ViewPager){
        tabAdapter = TabAdapter(supportFragmentManager)
        tabAdapter.addFragment(Movie(),getString(R.string.movie))
        tabAdapter.addFragment(TVShow(),getString(
                R.string.tvshow
            ))
        viewPager.adapter = tabAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }

}



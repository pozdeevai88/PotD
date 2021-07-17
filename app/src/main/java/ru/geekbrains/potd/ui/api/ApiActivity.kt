package ru.geekbrains.potd.ui.api

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.potd.R
import ru.geekbrains.potd.databinding.ActivityApiBinding

class ApiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.apply {
            viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
            tabLayout.setupWithViewPager(binding.viewPager)
            tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_earth)
            tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_mars)
            tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_system)
        }
        setCustomTabs()
    }


    private fun setCustomTabs() {
        val layoutInflater = LayoutInflater.from(this)
        binding.apply {
            tabLayout.getTabAt(0)?.customView =
                layoutInflater.inflate(R.layout.activity_api_custom_tab_earth, null)
            tabLayout.getTabAt(1)?.customView =
                layoutInflater.inflate(R.layout.activity_api_custom_tab_mars, null)
            tabLayout.getTabAt(2)?.customView =
                layoutInflater.inflate(
                    R.layout.activity_api_custom_tab_weather,
                    null
                )
        }
    }

}
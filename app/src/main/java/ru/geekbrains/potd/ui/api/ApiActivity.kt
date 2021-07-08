package ru.geekbrains.potd.ui.api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.potd.databinding.ActivityApiBinding

class ApiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
    }
}
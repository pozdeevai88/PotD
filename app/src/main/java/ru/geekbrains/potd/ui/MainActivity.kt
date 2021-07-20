package ru.geekbrains.potd.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.potd.R
import ru.geekbrains.potd.ui.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commitAllowingStateLoss()
        }
    }
}

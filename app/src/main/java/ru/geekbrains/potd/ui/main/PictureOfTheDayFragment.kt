package ru.geekbrains.potd.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import coil.api.load
import ru.geekbrains.potd.PictureOfTheDayData
import ru.geekbrains.potd.R
import ru.geekbrains.potd.databinding.MainFragmentBinding

class PictureOfTheDayFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    //Ленивая инициализация модели
    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProviders.of(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.layoutInput.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://en.wikipedia.org/wiki/${binding.inputEditText.text.toString()}")
            })
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, { renderData(it) })}

    private fun renderData(data: PictureOfTheDayData) {

        when (data) {
            is PictureOfTheDayData.Success -> {
                val serverResponseData = data.serverResponseData
                val url = serverResponseData.url
                if (url.isNullOrEmpty()) {
                    Toast.makeText(context, "EMPTY LINK", Toast.LENGTH_SHORT).show()
                } else {
                    binding.viewImage.load(url) {
                        lifecycle(this@PictureOfTheDayFragment)
                        error(R.drawable.ic_load_error_vector)
                        placeholder(R.drawable.ic_no_photo_vector)
                    }
                }
            }

            is PictureOfTheDayData.Loading -> { }
            is PictureOfTheDayData.Error -> { }
        }
    }

    companion object {
        fun newInstance() = PictureOfTheDayFragment()
        private var isMain = true
    }

}
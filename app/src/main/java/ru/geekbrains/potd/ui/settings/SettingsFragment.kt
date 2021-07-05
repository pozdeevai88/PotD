package ru.geekbrains.potd.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import ru.geekbrains.potd.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.chipGroup.setOnCheckedChangeListener { chipGroup, position ->
//            chipGroup.findViewById<Chip>(position)?.let {
//                Toast.makeText(
//                    context, "Выбран ${it.text}",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply { }
    }
}
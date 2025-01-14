package com.example.android.cactus.presentation.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentHandwritingBinding
import com.example.android.cactus.databinding.FragmentMonthBinding
import com.example.android.cactus.databinding.ItemMonthBinding
import com.example.android.cactus.domain.repository.HandwritingResponsitory
import com.example.android.cactus.domain.repository.MonthRepository
import com.example.android.cactus.presentation.adapter.MonthAdapter

class MonthFragment : Fragment(R.layout.fragment_month) {

    private var _binding: FragmentMonthBinding? = null
    private val binding get() = _binding!!
    private var mediaPlayer: MediaPlayer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMonthBinding.bind(view)

        // thêm đường kẻ
        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.rvMonth.addItemDecoration(dividerItemDecoration)

        binding.rvMonth.adapter = MonthAdapter(MonthRepository.months) { month ->
            playSound(month.soundResId)
        }
        binding.rvMonth.layoutManager = LinearLayoutManager(requireContext())

        binding.buttonback.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun playSound(soundResId: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(requireContext(), soundResId)
        mediaPlayer?.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mediaPlayer?.release()
    }
}

//    : Fragment() {
//    private var _binding: FragmentMonthBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentMonthBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    // Map các tháng với tệp âm thanh
//     val months = listOf(
//        Month("Январь", "Tháng Một", R.raw.one),
//        Month("Февраль", "Tháng Hai", R.raw.one),
//        Month("Март", "Tháng Ba", R.raw.one),
//        Month("Апрель", "Tháng Tư", R.raw.one),
//        Month("Май","Tháng Năm", R.raw.one),
//        Month("Июнь","Tháng Sáu", R.raw.one),
//        Month("Июль", "Tháng Bảy", R.raw.one),
//        Month("Август","Tháng Tám", R.raw.one),
//        Month("Сентябрь", "Tháng Chín", R.raw.one),
//        Month("Октябрь","Tháng Mười", R.raw.one),
//        Month("Ноябрь", "Tháng Mười Một", R.raw.one),
//        Month("Декабрь", "Tháng Mười Hai", R.raw.one)
//    )
//        // Set up RecyclerView
//        val adapter = MonthAdapter(months)
//        binding.rvMont.layoutManager = LinearLayoutManager(requireContext())
//        binding.rvMont.adapter = adapter
//
//        // Handle back button click
//        binding.buttonback.setOnClickListener {
//            Toast.makeText(requireContext(), "Back button clicked!", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}
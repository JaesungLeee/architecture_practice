package jaesung.project.architecturepractice.presentation.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import jaesung.project.architecturepractice.R
import jaesung.project.architecturepractice.databinding.FragmentHomeBinding
import jaesung.project.architecturepractice.presentation.common.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()
    }

    private fun bindViews() {
        binding.btnTest1.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_place)
        }
    }
}
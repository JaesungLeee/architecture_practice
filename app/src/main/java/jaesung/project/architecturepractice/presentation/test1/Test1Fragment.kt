package jaesung.project.architecturepractice.presentation.test1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import jaesung.project.architecturepractice.R
import jaesung.project.architecturepractice.databinding.FragmentPlaceBinding
import jaesung.project.architecturepractice.presentation.common.UiEvent
import jaesung.project.architecturepractice.presentation.common.UiState
import jaesung.project.architecturepractice.presentation.common.base.BaseFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class Test1Fragment : BaseFragment<FragmentPlaceBinding>(R.layout.fragment_place) {

    private val viewModel: Test1ViewModel by viewModel()
    private val adapter: Test1Adapter by lazy { Test1Adapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPlaceList()
        initUi()
        observe()
    }

    private fun initUi() = with(binding) {
        recyclerView.adapter = adapter

        toolBar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.placeFlow.collect { uiState ->
                    when (uiState) {
                        is UiState.Success -> {
                            Timber.e("SUCCESS")
                            dismissLoadingSpinner()
                            adapter.submitList(uiState.data.placeList)
                        }
                        is UiState.Loading -> {
                            Timber.e("LOADING")
                            showLoadingSpinner(requireContext())
                        }
                        is UiState.Error -> {
                            Timber.e("FAILED")
                            dismissLoadingSpinner()
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.eventFlow.collect { event ->
                    handleEvent(event)
                }
            }
        }
    }

    private fun handleEvent(event: UiEvent) {
        when (event) {
            is UiEvent.ShowToast -> Toast.makeText(requireContext(), event.message, Toast.LENGTH_SHORT).show()
        }
    }

}
package jaesung.project.architecturepractice.presentation.common.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import jaesung.project.architecturepractice.presentation.common.CustomSpinner

open class BaseFragment<T : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : Fragment() {

    private var _binding: T? = null
    val binding get() = requireNotNull(_binding)

    lateinit var spinner: CustomSpinner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    fun showLoadingSpinner(context: Context) {
        spinner = CustomSpinner(context)
        spinner.show()
    }

    fun dismissLoadingSpinner() {
        if (spinner.isShowing) {
            spinner.dismiss()
        }
    }
}
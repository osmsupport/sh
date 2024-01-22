package com.example.webeteer.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragmentDataBinding<T : ViewDataBinding, V : ViewModel?> : Fragment() {

    private var mViewModel: V? = null
    private var _binding: T? = null
    protected val binding get() = _binding!!
    protected lateinit var loader: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.setVariable(getBindingVariable(), mViewModel)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.executePendingBindings()

        loader = ProgressDialog(requireContext())

        initLayout()
    }

    abstract fun getBindingVariable(): Int

    abstract fun getViewModel(): V

    abstract fun getLayoutId(): Int

    abstract fun initLayout()

    abstract fun setupObservers()

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
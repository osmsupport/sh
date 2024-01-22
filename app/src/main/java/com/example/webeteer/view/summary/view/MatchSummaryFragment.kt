package com.example.webeteer.view.summary.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.webeteer.BR
import com.example.webeteer.R
import com.example.webeteer.base.BaseFragmentDataBinding
import com.example.webeteer.databinding.FragmentMatchSummaryBinding
import com.example.webeteer.view.MainActivityVM
import com.example.webeteer.view.summary.viewmodel.MatchSummaryFragmentVM
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MatchSummaryFragment : BaseFragmentDataBinding<FragmentMatchSummaryBinding, MatchSummaryFragmentVM>() {
    private val activityVM: MainActivityVM by activityViewModels()
    private val vm: MatchSummaryFragmentVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.loadSummaryData(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): MatchSummaryFragmentVM = vm

    override fun getLayoutId(): Int = R.layout.fragment_match_summary

    override fun initLayout() {

    }

    override fun onResume() {
        super.onResume()
        activityVM.toolbarTitle.value = "Match Summary"
    }

    override fun setupObservers() {
        vm.matchSummaryData.observe(viewLifecycleOwner) {

        }
        vm.navigateToScoreCard.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(MatchSummaryFragmentDirections.actionScoreCardFragment())
            }
        }
    }

}
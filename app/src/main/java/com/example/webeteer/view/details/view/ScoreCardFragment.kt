package com.example.webeteer.view.details.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.webeteer.BR
import com.example.webeteer.R
import com.example.webeteer.base.BaseFragmentDataBinding
import com.example.webeteer.databinding.FragmentScoreCardBinding
import com.example.webeteer.view.MainActivityVM
import com.example.webeteer.view.details.adapter.BattersListAdapter
import com.example.webeteer.view.details.adapter.BowlersListAdapter
import com.example.webeteer.view.details.adapter.WicketFallsAdapter
import com.example.webeteer.view.details.viewmodel.ScoreCardFragmentVM
import com.example.webeteer.view.summary.model.Bowler
import com.example.webeteer.view.summary.model.Player
import com.example.webeteer.view.summary.model.Wicket
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScoreCardFragment : BaseFragmentDataBinding<FragmentScoreCardBinding, ScoreCardFragmentVM>() {
    private val activityVM: MainActivityVM by activityViewModels()
    private val vm: ScoreCardFragmentVM by viewModels()
    private val battersListTeamA = ArrayList<Player>()
    private val adapterBattersTeamA: BattersListAdapter by lazy {
        BattersListAdapter(requireContext(), battersListTeamA)
    }
    private val bowlersListTeamA = ArrayList<Bowler>()
    private val adapterBowlersTeamA: BowlersListAdapter by lazy {
        BowlersListAdapter(requireContext(), bowlersListTeamA)
    }
    private val wicketsListTeamA = ArrayList<Wicket>()
    private val adapterWicketsTeamA: WicketFallsAdapter by lazy {
        WicketFallsAdapter(requireContext(), wicketsListTeamA)
    }

    private val battersListTeamB = ArrayList<Player>()
    private val adapterBattersTeamB: BattersListAdapter by lazy {
        BattersListAdapter(requireContext(), battersListTeamB)
    }
    private val bowlersListTeamB = ArrayList<Bowler>()
    private val adapterBowlersTeamB: BowlersListAdapter by lazy {
        BowlersListAdapter(requireContext(), bowlersListTeamB)
    }
    private val wicketsListTeamB = ArrayList<Wicket>()
    private val adapterWicketsTeamB: WicketFallsAdapter by lazy {
        WicketFallsAdapter(requireContext(), wicketsListTeamB)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.loadSummaryData(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): ScoreCardFragmentVM = vm

    override fun getLayoutId(): Int = R.layout.fragment_score_card

    override fun initLayout() {

        binding.rvBattersTeamA.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))
        binding.rvBattersTeamA.adapter = adapterBattersTeamA

        binding.rvBowlersTeamA.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))
        binding.rvBowlersTeamA.adapter = adapterBowlersTeamA

        binding.rvWicketsTeamA.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))
        binding.rvWicketsTeamA.adapter = adapterWicketsTeamA

        binding.rvBattersTeamB.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))
        binding.rvBattersTeamB.adapter = adapterBattersTeamB

        binding.rvBowlersTeamB.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))
        binding.rvBowlersTeamB.adapter = adapterBowlersTeamB

        binding.rvWicketsTeamB.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))
        binding.rvWicketsTeamB.adapter = adapterWicketsTeamB
    }

    override fun setupObservers() {
        vm.matchSummaryData.observe(viewLifecycleOwner) {
            activityVM.toolbarTitle.value = "${it.teams[0].name} v ${it.teams[1].name}"
        }
        vm.teamA.observe(viewLifecycleOwner) {
            battersListTeamA.clear()
            battersListTeamA.addAll(it.players)
            adapterBattersTeamA.notifyDataSetChanged()

            bowlersListTeamA.clear()
            bowlersListTeamA.addAll(it.bowlers)
            adapterBowlersTeamA.notifyDataSetChanged()

        }
        vm.teamB.observe(viewLifecycleOwner) {
            battersListTeamB.clear()
            battersListTeamB.addAll(it.players)
            adapterBattersTeamB.notifyDataSetChanged()

            bowlersListTeamB.clear()
            bowlersListTeamB.addAll(it.bowlers)
            adapterBowlersTeamB.notifyDataSetChanged()
        }
        vm.wicketsTeamA.observe(viewLifecycleOwner) {
            wicketsListTeamA.clear()
            wicketsListTeamA.addAll(it)
            adapterWicketsTeamA.notifyDataSetChanged()
        }
        vm.wicketsTeamB.observe(viewLifecycleOwner) {
            wicketsListTeamB.clear()
            wicketsListTeamB.addAll(it)
            adapterWicketsTeamB.notifyDataSetChanged()
        }

    }

}
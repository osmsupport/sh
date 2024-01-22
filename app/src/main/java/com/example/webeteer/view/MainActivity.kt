package com.example.webeteer.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.webeteer.BR
import com.example.webeteer.R
import com.example.webeteer.base.BaseActivityDataBinding
import com.example.webeteer.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivityDataBinding<ActivityMainBinding, MainActivityVM>() {
    private val vm: MainActivityVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupObservers()
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): MainActivityVM = vm

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initLayout() {
        setSupportActionBar(binding.materialToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.materialToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fcMain.id) as NavHostFragment
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener(destinationListener)
    }

    override fun setupParameters() {
    }

    override fun setupObservers() {
    }

    private val destinationListener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
        when (destination.id) {
            R.id.matchSummaryFragment -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                supportActionBar?.setDisplayShowHomeEnabled(false)
            }

            R.id.scoreCardFragment -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setDisplayShowHomeEnabled(true)
            }
        }
    }
}
package com.example.android.examenadolfo.presentation.ui

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.PopupMenu
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.navigation.NavController

import javax.inject.Inject
import androidx.navigation.findNavController
import com.example.android.examenadolfo.App
import com.example.android.examenadolfo.R
import com.example.android.examenadolfo.databinding.ActivityMainBinding
import com.example.android.examenadolfo.domain.data.HeroesRepository
import com.example.android.examenadolfo.presentation.BaseViewModelActivity
import com.example.android.examenadolfo.presentation.ui.tvs.HeroesViewModel

import com.example.android.examenadolfo.utils.NetworkConnection
import com.frentetecnologicoponce.elder.presentation.ViewModelFactory
import com.frentetecnologicoponce.elder.presentation.di.DaggerAuthenticationComponent


class MainActivity : BaseViewModelActivity<HeroesViewModel>() {

    @Inject
    lateinit var loginRepository: HeroesRepository
    private lateinit var navController: NavController

    private val authViewModel by viewModels<HeroesViewModel> {
        ViewModelFactory( loginRepository,this, intent.extras)
    }

    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        initInjection()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.main_fragment)
        setupSmoothBottomMenu()
        if (Build.VERSION.SDK_INT >= 21) {
            val window: Window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setStatusBarColor(this.resources.getColor(R.color.colorPrimary))
        }
        initServices()
    }


    private fun setupSmoothBottomMenu() {
        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.menu)
        val menu = popupMenu.menu
        binding.bottomBar.setupWithNavController(menu, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override val baseViewModel: HeroesViewModel
        get() = authViewModel

    private fun initInjection() {
        val component = DaggerAuthenticationComponent.builder()
            .applicationComponent(App.applicationComponent)
            .build()

        component.inject(this)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initServices() {
        if (NetworkConnection.hasInternetConnection(this)) {}
    }






}
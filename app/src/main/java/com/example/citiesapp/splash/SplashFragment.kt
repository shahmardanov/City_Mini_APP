package com.example.lazaapp.ui.splash

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.citiesapp.base.BaseFragment
import com.example.citiesapp.databinding.SplashViewBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : BaseFragment<SplashViewBinding>(SplashViewBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forwardFragment()
    }

    private fun forwardFragment() {
        lifecycleScope.launch {
            delay(1500)
            Toast.makeText(context, "Welcome!", Toast.LENGTH_LONG).show()
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())

        }
    }


}

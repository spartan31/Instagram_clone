package com.example.instagram.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.instagram.R
import com.example.instagram.databinding.LoginFragmentBinding
import com.example.instagram.viewModels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding
    private val authViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = authViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewModel.authStatus.observe(viewLifecycleOwner) { result ->
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Default) {
                result.onSuccess {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                        val navHostFragment =
                            requireActivity().supportFragmentManager.findFragmentById(R.id.containerFragment) as NavHostFragment
                        val navController = navHostFragment.navController
                        navController.setGraph(R.navigation.bottom_nav_graph)
                        navController.navigate(R.id.homeFragment)
                    }
                }.onFailure {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
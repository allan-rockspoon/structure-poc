package com.example.poc.auth.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.poc.auth.R
import com.example.poc.auth.databinding.AuthFragmentBinding
import com.example.poc.auth.domain.SignUpWithPasswordUseCase
import com.example.poc.auth.loadModules
import com.example.poc.core.data.user.User
import com.example.poc.core.ui.BindableFragment
import com.example.poc.ui.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : BindableFragment<AuthFragmentBinding>() {

    private val mainViewModel: MainViewModel by sharedViewModel()

    private val viewModel: AuthViewModel by viewModel()

    override fun viewBindingInflate() = AuthFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Initialize the dependency injection modules for this project module
        loadModules()

        // Setup UI
        binding.passwordEditText.setText(viewModel.user.password)
        binding.authButton.setOnClickListener {
            viewModel.user.password = binding.passwordEditText.text.toString()
            viewModel.user.email = binding.emailEditText.text.toString()
            viewModel.signUp()
        }

        // Observe UI state
        viewModel.uiState.onEach { uiState ->
            when (uiState) {
                UiState.None -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(null)
                }
                is UiState.Loading -> {
                    updateProgressIndicator(uiState.progress ?: UiState.Loading.INDETERMINATE)
                    updateErrorMessages(null)
                }
                is UiState.Success -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(null)
                    notifyOnAuthSuccess()
                }
                is UiState.Error -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(uiState.exception)
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    /**
     * Progress equals to -1 means INDETERMINATE, null means hide it, and between 0 and 100 means
     * executing.
     */
    private fun updateProgressIndicator(progress: Int?) {
        binding.authButton.isEnabled = progress == null
        binding.progressIndicator.isVisible = progress != null
        binding.progressIndicator.isIndeterminate = progress == UiState.Loading.INDETERMINATE
        binding.progressIndicator.progress = progress ?: 0
    }

    private fun updateErrorMessages(t: Throwable? = null) {

        // It concerns to the UI layer, specifically activities and fragments, translate the message
        // from technical English to the user language. The specific message should be provided
        // by the design team and should consider clarity to the target users and align with the
        // intonation of the general marketing strategy. Here we used a informal one, which is never
        // allowed in the exception message itself. The message for the user must contain
        // information suggesting how the user should respond, like "Try later" for unknown errors
        // that we should fix or indicating how to insert valid inputs.
        when (t) {
            is SignUpWithPasswordUseCase.UserPasswordTooShortException -> {
                binding.passwordInputLayout.error =
                    getText(R.string.error_authentication_password_short)
            }
            null -> {
                binding.passwordInputLayout.error = null
            }
            else -> {
                val message = getText(R.string.error_authentication_unknown)
                Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun notifyOnAuthSuccess() {
        // TODO Maybe use a view model to coordinate this or create a listener interface so any
        //      activity be able to be notified. IOsched uses a .receiveAsFlow and a Channel to
        //      receive events related to navigation. I can maybe put ond like them on the
        //      MainActivity view model and publish a 'on auth' event that will trigger the
        //      MainActivity to make the navigation.

        // Note that we don't navigate to home screen. A feature module should be complete ignorant
        // about the reasons why it was invoked, this includes knowing what it will be done with
        // it's results, so make it call a function with explicitly naming indicating where to go
        // next would break this paradigm. Instead the feature only call a function indicating that
        // it's job is completed. The reason is because the feature should be treated as if it can
        // be invoked for multiple reasons. Now we are invoking authentication for the home screen,
        // but we could invoked it for seeing a credit card info, for example.
        mainViewModel.onEvent(MainViewModel.Event.AuthenticationCompleted)
    }

    sealed class UiState {
        object None : UiState()
        data class Loading(val progress: Int?) : UiState() {
            companion object {
                const val INDETERMINATE = -1
            }
        }

        data class Success(val item: User) : UiState()
        data class Error(val exception: Exception) : UiState()
    }
}
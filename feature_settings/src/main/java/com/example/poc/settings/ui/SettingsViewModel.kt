package com.example.poc.settings.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poc.core.domain.base.UseCase
import com.example.poc.core.domain.preference.ObserveIsNotificationEnabledUseCase
import com.example.poc.core.domain.preference.ObserveThemeUseCase
import com.example.poc.core.data.preference.Theme
import com.example.poc.settings.domain.UpdateIsNotificationEnabledUseCase
import com.example.poc.settings.domain.UpdateThemeUseCase
import com.example.poc.settings.ui.SettingsFragment.UiState.Companion.success
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SettingsViewModel(
    observeIsNotificationEnabledUseCase: ObserveIsNotificationEnabledUseCase,
    observeThemeUseCase: ObserveThemeUseCase,
    private val updateThemeUseCase: UpdateThemeUseCase,
    private val updateIsNotificationEnabledUseCase: UpdateIsNotificationEnabledUseCase
) : ViewModel() {

    // Prefer not make more than one uiState per view model. If you need more data
    // put inside success data class. If you need to serve multiple fragments,
    // make multiple view models or one with activity scope and a more complete
    // Success data class. There is many ways of keeping this clean.
    private val _uiState: MutableStateFlow<SettingsFragment.UiState> =
        MutableStateFlow(SettingsFragment.UiState.None)
    val uiState: StateFlow<SettingsFragment.UiState> = _uiState

    init {
        observeThemeUseCase(Unit)
            .onEach { result ->
                when (result) {
                    is UseCase.Result.Loading -> _uiState.value =
                        SettingsFragment.UiState.Loading(progress = result.progress)
                    is UseCase.Result.Success -> _uiState.update {
                        it.success.copy(theme = result.data)
                    }
                    is UseCase.Result.Error -> _uiState.value =
                        SettingsFragment.UiState.Error(exception = result.exception)
                }
            }
            .launchIn(viewModelScope)

        observeIsNotificationEnabledUseCase(Unit)
            .onEach { result ->
                when (result) {
                    is UseCase.Result.Loading -> _uiState.value =
                        SettingsFragment.UiState.Loading(progress = result.progress)
                    is UseCase.Result.Success -> _uiState.update {
                        it.success.copy(isNotificationEnabled = result.data)
                    }
                    is UseCase.Result.Error -> _uiState.value =
                        SettingsFragment.UiState.Error(exception = result.exception)
                }
            }
            .launchIn(viewModelScope)

        // Observe other attributes here...
    }

    fun setTheme(theme: Theme) {
        viewModelScope.launch {
            updateThemeUseCase(theme)
        }
    }

    fun setIsNotificationEnabled(isNotificationEnabled: Boolean) {
        viewModelScope.launch {
            updateIsNotificationEnabledUseCase(isNotificationEnabled)
        }
    }
}
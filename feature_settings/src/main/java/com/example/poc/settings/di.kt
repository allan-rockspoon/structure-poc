package com.example.poc.settings

import com.example.poc.settings.domain.UpdateIsNotificationEnabledUseCase
import com.example.poc.settings.domain.UpdateThemeUseCase
import com.example.poc.settings.ui.SettingsViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val featureSettingsModule = module {

    single {
        Dispatchers.IO
    }

    singleOf(::UpdateIsNotificationEnabledUseCase)

    singleOf(::UpdateThemeUseCase)

    viewModelOf(::SettingsViewModel)
}

// Use lazy to only call it once
private val lazyLoadModules = lazy {
    GlobalContext.loadKoinModules(featureSettingsModule)
}

fun loadModules() {
    lazyLoadModules.value
}
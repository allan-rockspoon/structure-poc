package com.example.poc.core.data

import androidx.room.Room
import com.example.poc.core.data.preferences.PreferencesDataSource
import com.example.poc.core.data.preferences.PreferencesDataSourceImpl
import com.example.poc.core.data.preferences.PreferencesDataSourceImpl.Companion.preferencesDataStore
import com.example.poc.core.data.user.*
import com.example.poc.datasource.database.Database
import com.example.poc.datasource.remoteclientapi.RemoteClientApiClient
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun coreDataModule() = module {

    // Database
    single {
        Room.databaseBuilder(
            androidApplication(),
            Database::class.java,
            "main"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    // ApiClient
    single {
        RemoteClientApiClient()
    }

    // DataSource<Preferences>
    single<PreferencesDataSource> {
        PreferencesDataSourceImpl(
            dataStore = androidApplication().preferencesDataStore
        )
    }

    // User
    singleOf(::UserDatabaseDataSourceImpl) { bind<UserDatabaseDataSource>() }
    singleOf(::UserRemoteDataSourceImpl) { bind<UserRemoteDataSource>() }
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }

}
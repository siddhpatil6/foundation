package com.foundation.di

import com.foundation.MainActivity
import dagger.Component


@Component(modules = [AppModule::class, FoundationModule::class])
interface FoundationListComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(foundationListViewModelFactory: FoundationListViewModelFactory)

}
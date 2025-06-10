package com.grosskreutz.maxshoes.modulo

import android.content.Context
import com.grosskreutz.maxshoes.dao.ProductsRepository
import com.grosskreutz.maxshoes.ui.home.viewmodel.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get(), get()) }
    single { providePackageName(androidContext()) }
    single { ProductsRepository() }
}

fun providePackageName(context: Context): String = context.packageName
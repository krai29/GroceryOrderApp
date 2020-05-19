package com.krai29.groceryorderapp

import android.app.Application
import com.krai29.groceryorderapp.data.db.ShoppingDatabase
import com.krai29.groceryorderapp.data.repositories.ShoppingRepository
import com.krai29.groceryorderapp.ui.viewmodel.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShoppingApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        /* lazy means we can use application context during binding time.
         We need that for shopping db which takes context as a parameter */

        import(androidXModule(this@ShoppingApplication))
        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from provider {
            ShoppingViewModelFactory(instance()) }
    }
}
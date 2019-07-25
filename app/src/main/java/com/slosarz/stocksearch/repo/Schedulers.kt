/*
 *  Created by Rafal Slosarz
 *  Copyright (c) 2019 . All rights reserved.
 */

package com.slosarz.stocksearch.repo

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Interface for RxJava Schedulers
 */
interface SchedulerProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
}

/**
 * Production implementation of Schedulers
 */
class ProductionSchedulerProvider : SchedulerProvider {
    override fun io() = Schedulers.io()
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
}

/**
 * Implementation used in tests.
 * Trampoline executes all tasks in a FIFO manner on one of the participating threads
 * so all the operations will be called on the same thread one after another.
 * This does not require additional actions in UT to handle async operations
 */
class TrampolineSchedulerProvider : SchedulerProvider {
    override fun io() = Schedulers.trampoline()
    override fun ui() = Schedulers.trampoline()
}

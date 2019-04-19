package com.banty.base

import androidx.annotation.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject

/**
 * Created by Banty on 2019-04-19.
 * This is for communication between observer module and console at base module
 */
class ConsoleMessagePublisher<String> {

    companion object {
        private val instance : ConsoleMessagePublisher<String> = ConsoleMessagePublisher()

        @Synchronized
        fun getInstance() : ConsoleMessagePublisher<String> {
            return instance
        }
    }

    private val publisher = PublishSubject.create<String>()

    fun subscribe(@NonNull consumer: Consumer<String>): Disposable {
        return publisher.subscribe(consumer)
    }

    fun sendEvent(message: String) {
        publisher.onNext(message)
    }
}
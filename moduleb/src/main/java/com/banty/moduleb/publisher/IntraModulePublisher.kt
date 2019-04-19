package com.banty.moduleb.publisher

import androidx.annotation.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject

/**
 * Created by Banty on 2019-04-19.
 */
class IntraModulePublisher<String> {

    companion object {
        private val instance : IntraModulePublisher<String> = IntraModulePublisher()

        @Synchronized
        fun getInstance() : IntraModulePublisher<String> {
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
package com.banty.moduleb


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.banty.base.ConsoleMessagePublisher
import com.banty.base.EventPublisher
import com.banty.moduleb.publisher.IntraModulePublisher
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.fragment_module_b.*

/**
 * A simple [Fragment] subclass.
 */
class ModuleBFragment<T> : Fragment(), Consumer<String> {

    private lateinit var subscription: Disposable

    private lateinit var intraModuleSubscription : Disposable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_module_b, container, false)
        subscription = EventPublisher.getInstance().subscribe(this)
        intraModuleSubscription = IntraModulePublisher.getInstance().subscribe(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_moduleb_stopSub.setOnClickListener {
            if (!subscription.isDisposed) {
                subscription.dispose()
                ConsoleMessagePublisher.getInstance().sendEvent("Module B unsubscribed\n")
            }
        }

        button_moduleb_sendIntra.setOnClickListener {
            IntraModulePublisher.getInstance().sendEvent("Message from B")
        }
    }

    override fun accept(message: String?) {
        Log.d("Rx", "Module B : $message\n")
        ConsoleMessagePublisher.getInstance().sendEvent("Message received by module B : $message\n")
    }


}

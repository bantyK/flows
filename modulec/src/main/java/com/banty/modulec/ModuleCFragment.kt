package com.banty.modulec


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.banty.base.ConsoleMessagePublisher
import com.banty.base.EventPublisher
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.fragment_module_c.*

/**
 * A simple [Fragment] subclass.
 */
class ModuleCFragment : Fragment(), Consumer<String> {

    private lateinit var subscription: Disposable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_module_c, container, false)
        subscription = EventPublisher.getInstance().subscribe(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_modulec_stopSub.setOnClickListener {
            if (!subscription.isDisposed) {
                subscription.dispose()
                ConsoleMessagePublisher.getInstance().sendEvent("Module C unsubscribed\n")
            }
        }
    }

    override fun accept(message: String?) {
        Log.d("Rx", "Module C : $message\n")
        ConsoleMessagePublisher.getInstance().sendEvent("Message received by module C : $message\n")
    }
}

package com.banty.modulea


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.banty.base.EventPublisher
import kotlinx.android.synthetic.main.fragment_module_a.*

/**
 * This class acts as an observable
 */
class ModuleAFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_moduleA_sendEvent.setOnClickListener {
            EventPublisher.getInstance().sendEvent("Payload")
        }
    }


}

package com.banty.flows

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.banty.base.ConsoleMessagePublisher
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Consumer<String> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ConsoleMessagePublisher.getInstance().subscribe(this)

    }

    override fun accept(message: String) {
        textView_console.append(message)
    }
}

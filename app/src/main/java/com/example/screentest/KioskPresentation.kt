package com.example.screentest

import android.app.Presentation
import android.content.Context
import android.os.Bundle
import android.view.Display
import android.view.View
import android.widget.GridView

enum class KioskMode {
    Logo, Kiosk, Pos
}

class KioskPresentation(outerContext: Context?, display: Display?) :
    Presentation(outerContext, display){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (mode == KioskMode.Logo) {
            setContentView(R.layout.activity_main3)
            return
        }

    }

    companion object {

        var mode: KioskMode = KioskMode.Logo
    }
}

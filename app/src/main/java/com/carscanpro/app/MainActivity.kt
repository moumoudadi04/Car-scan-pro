package com.carscanpro.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setBackgroundColor(Color.WHITE)
        layout.setPadding(24, 24, 24, 24)

        val title = TextView(this)
        title.text = "Car Scan Pro"
        title.textSize = 30f
        title.setTextColor(Color.rgb(20, 60, 110))
        title.gravity = Gravity.CENTER

        val description = TextView(this)
        description.text = "Professional Vehicle Scanner"
        description.textSize = 18f
        description.setTextColor(Color.DKGRAY)
        description.gravity = Gravity.CENTER

        layout.addView(title)
        layout.addView(description)

        setContentView(layout)
    }
}

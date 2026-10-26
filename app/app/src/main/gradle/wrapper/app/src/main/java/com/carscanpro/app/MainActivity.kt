package com.carscanpro.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {

private lateinit var statusText: TextView
private lateinit var resultText: TextView

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    window.statusBarColor = Color.rgb(15, 23, 42)
    window.navigationBarColor = Color.rgb(15, 23, 42)

    val root = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(24, 24, 24, 24)
        setBackgroundColor(Color.rgb(15, 23, 42))
        layoutDirection = View.LAYOUT_DIRECTION_RTL
    }

    val scroll = ScrollView(this)
    val content = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        layoutDirection = View.LAYOUT_DIRECTION_RTL
    }

    val title = TextView(this).apply {
        text = "Car Scan Pro"
        textSize = 30f
        setTextColor(Color.WHITE)
        gravity = Gravity.CENTER
        setPadding(8, 20, 8, 8)
    }
    content.addView(title)

    val subtitle = TextView(this).apply {
        text = "نظام احترافي لتشخيص السيارات"
        textSize = 18f
        setTextColor(Color.LTGRAY)
        gravity = Gravity.CENTER
        setPadding(8, 8, 8, 24)
    }
    content.addView(subtitle)

    statusText = TextView(this).apply {
        text = "● غير متصل بجهاز OBD2"
        textSize = 17f
        setTextColor(Color.rgb(255, 190, 80))
        gravity = Gravity.CENTER
        setPadding(12, 20, 12, 20)
    }
    content.addView(statusText)

    addSection(content, "لوحة تشخيص السيارة")

    addInfoCard(content, "سرعة المحرك", "-- RPM")
    addInfoCard(content, "درجة حرارة المحرك", "-- °C")
    addInfoCard(content, "جهد البطارية", "-- V")
    addInfoCard(content, "سرعة السيارة", "-- km/h")

    addSection(content, "أدوات الفحص")

    addActionButton(content, "🔎 فحص أكواد الأعطال") {
        resultText.text =
            "لم يتم إجراء فحص حقيقي بعد.\nاتصل بجهاز OBD2 متوافق لقراءة الأعطال."
    }

    addActionButton(content, "📡 الاتصال بجهاز OBD2") {
        resultText.text =
            "ميزة الاتصال قيد التطوير.\nسنضيف دعم Bluetooth وWi-Fi في المراحل التالية."
    }

    addActionButton(content, "🌐 اللغة / Language / Langue") {
        resultText.text =
            "الواجهة العربية متاحة حاليًا.\nسيتم تطوير اللغتين الفرنسية والإنجليزية لاحقًا."
    }

    resultText = TextView(this).apply {
        text = "مرحبًا بك في Car Scan Pro"
        textSize = 16f
        setTextColor(Color.WHITE)
        gravity = Gravity.CENTER
        setPadding(12, 24, 12, 24)
    }
    content.addView(resultText)

    scroll.addView(content)
    root.addView(
        scroll,
        LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
    )

    setContentView(root)
}

private fun addSection(parent: LinearLayout, text: String) {
    val heading = TextView(this).apply {
        this.text = text
        textSize = 21f
        setTextColor(Color.rgb(56, 189, 248))
        setPadding(4, 24, 4, 12)
    }
    parent.addView(heading)
}

private fun addInfoCard(
    parent: LinearLayout,
    label: String,
    value: String
) {
    val card = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(18, 16, 18, 16)
        setBackgroundColor(Color.rgb(30, 41, 59))
    }

    val labelView = TextView(this).apply {
        text = label
        textSize = 16f
        setTextColor(Color.LTGRAY)
    }

    val valueView = TextView(this).apply {
        text = value
        textSize = 23f
        setTextColor(Color.WHITE)
        setPadding(0, 8, 0, 0)
    }

    card.addView(labelView)
    card.addView(valueView)

    val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )
    params.setMargins(0, 6, 0, 6)
    parent.addView(card, params)
}

private fun addActionButton(
    parent: LinearLayout,
    text: String,
    action: () -> Unit
) {
    val button = Button(this).apply {
        this.text = text
        textSize = 16f
        setOnClickListener { action() }
    }

    val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )
    params.setMargins(0, 6, 0, 6)
    parent.addView(button, params)
}

}

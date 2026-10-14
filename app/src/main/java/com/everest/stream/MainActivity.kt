package com.everest.stream

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val infoText = TextView(this).apply {
            text = """
                EverestStream Active!
                
                1. Ensure Android Auto Developer Mode is enabled.
                2. Ensure 'Unknown Sources' is checked in AA Developer Settings.
                3. Install this APK via KingInstaller or ADB with:
                   adb install -i "com.android.vending" app-debug.apk
            """.trimIndent()
            textSize = 16f
            setPadding(48, 64, 48, 48)
        }
        setContentView(infoText)
    }
}

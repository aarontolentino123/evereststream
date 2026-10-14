package com.everest.stream

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import com.google.android.apps.auto.sdk.CarActivity

class EverestCarActivity : CarActivity() {

    private lateinit var webView: WebView
    private lateinit var urlInput: EditText

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.BLACK)
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        // Top Navigation Bar for Ford Everest Portrait/Landscape Screen
        val navBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setBackgroundColor(Color.parseColor("#1E1E1E"))
            gravity = Gravity.CENTER_VERTICAL
            setPadding(12, 8, 12, 8)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val btnBack = createNavButton("◄") { if (webView.canGoBack()) webView.goBack() }
        val btnYT = createNavButton("YouTube") { webView.loadUrl("https://m.youtube.com") }
        val btnTV = createNavButton("YT TV") { webView.loadUrl("https://www.youtube.com/tv") }

        urlInput = EditText(this).apply {
            hint = "Enter URL..."
            setTextColor(Color.WHITE)
            setHintTextColor(Color.GRAY)
            setSingleLine(true)
            layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        }

        val btnGo = createNavButton("Go") {
            var url = urlInput.text.toString().trim()
            if (!url.startsWith("http")) url = "https://$url"
            webView.loadUrl(url)
        }

        navBar.addView(btnBack)
        navBar.addView(btnYT)
        navBar.addView(btnTV)
        navBar.addView(urlInput)
        navBar.addView(btnGo)

        // Fullscreen Hardware-Accelerated WebView
        webView = WebView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                mediaPlaybackRequiresUserGesture = false
                mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                userAgentString = "Mozilla/5.0 (Linux; Android 14; SM-S948B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36"
            }
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            loadUrl("https://m.youtube.com")
        }

        rootLayout.addView(navBar)
        rootLayout.addView(webView)
        setContentView(rootLayout)
    }

    private fun createNavButton(label: String, onClick: () -> Unit): Button {
        return Button(this).apply {
            text = label
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.parseColor("#333333"))
            setOnClickListener { onClick() }
        }
    }
}

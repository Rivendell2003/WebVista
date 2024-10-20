//@Author Jonathan V. Apiolaza
//@Date 20/10/2024
//@Version 1.0

package com.example.webvista

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView = findViewById(R.id.webView)

        val url = intent.getStringExtra("url")

        // la config del WebView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false // esto por temas de compatibilidad para Android 21 y superior
            }

            @Deprecated("This method is deprecated. Use shouldOverrideUrlLoading(WebView, WebResourceRequest) instead.")
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return false // anteriores a Android 21
            }
        }

        webView.loadUrl(url ?: "https://www.google.com") // URL por defecto si no se pone nada
    }
}

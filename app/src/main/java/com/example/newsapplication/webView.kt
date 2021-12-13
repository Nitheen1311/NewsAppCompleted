package com.example.newsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.Toolbar

class webView : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val toolbar : Toolbar= findViewById(R.id.toolbar)
      val  webView : WebView=findViewById(R.id.webView)
        setSupportActionBar(toolbar)
        val intent : Intent = getIntent()
        val url = intent.getStringExtra("url")
        webView.webViewClient=object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                if (url != null) {
                    view?.loadUrl(url)


                }
                return true
                 }

        }
        if (url != null)
        webView.loadUrl(url)


    }
}
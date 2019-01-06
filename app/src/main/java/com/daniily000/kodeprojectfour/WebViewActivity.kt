package com.daniily000.kodeprojectfour

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*


class WebViewActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "name"
        const val EXTRA_URL = "_url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        setSupportActionBar(toolbar_web)

        supportActionBar?.title = intent.getStringExtra(EXTRA_NAME) + " " +
                getString(R.string.web_view_title_suffix)
        web_view.webViewClient = WebViewClient()
        web_view.loadUrl(intent.getStringExtra(EXTRA_URL))
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        web_view.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        web_view.restoreState(savedInstanceState)
    }

    override fun onBackPressed() {
        if (web_view.canGoBack()) web_view.goBack()
        else super.onBackPressed()
    }
}
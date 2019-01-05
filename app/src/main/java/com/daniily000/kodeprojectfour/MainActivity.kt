package com.daniily000.kodeprojectfour

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.daniily000.kodeprojectfour.data.Languages
import com.daniily000.kodeprojectfour.view.LanguageAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val SPAN_COUNT = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        languages_list.layoutManager = GridLayoutManager(this, SPAN_COUNT)
        languages_list.adapter = LanguageAdapter(Languages.list)

    }

}
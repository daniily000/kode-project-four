package com.daniily000.kodeprojectfour

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import com.daniily000.kodeprojectfour.data.Language
import com.daniily000.kodeprojectfour.data.Languages
import com.daniily000.kodeprojectfour.view.LanguageAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mCurrentLanguagesList: MutableList<Language> = Languages.list.toMutableList()

    companion object {
        private const val SPAN_COUNT = 1
        private const val SEARCH_BAR_STATE_VISIBILITY = "search_bar_visibility"
        private const val SEARCH_BAR_STATE_TEXT = "search_bar_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        languages_list.layoutManager = GridLayoutManager(this, SPAN_COUNT)
        languages_list.adapter = LanguageAdapter(mCurrentLanguagesList).also {
            it.listener = {language ->
                startActivity(Intent(this, WebViewActivity::class.java).apply {
                    putExtra(WebViewActivity.EXTRA_NAME, language.name)
                    putExtra(WebViewActivity.EXTRA_URL, language.infoPage.toString())
                })
            }
        }

        search_bar.clearFocus()

        search_bar.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus && search_bar.text.isEmpty()) v.clearFocus()
        }

        search_bar.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {

                mCurrentLanguagesList.clear()
                Languages.list.forEach {
                    if (it.searchParadigms(
                            *search_bar.text.toString().trim().split(
                                " ",
                                ",",
                                ignoreCase = true
                            ).toTypedArray()
                        )
                    ) mCurrentLanguagesList.add(it)
                }
                languages_list.adapter?.notifyDataSetChanged()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {

        R.id.action_search -> {

            if (search_bar.visibility == GONE) {
                search_bar.visibility = VISIBLE
                search_bar.requestFocus()
            } else {
                search_bar.visibility = GONE
                search_bar.setText("")
                search_bar.clearFocus()
            }
            true
        }

        else -> super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(SEARCH_BAR_STATE_VISIBILITY, search_bar.visibility)
        outState?.putString(SEARCH_BAR_STATE_TEXT, search_bar.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        search_bar.visibility = savedInstanceState?.getInt(SEARCH_BAR_STATE_VISIBILITY) ?: GONE
        search_bar.setText(savedInstanceState?.getString(SEARCH_BAR_STATE_TEXT) ?: "")
    }
}
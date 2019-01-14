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
import com.daniily000.kodeprojectfour.data.Author
import com.daniily000.kodeprojectfour.data.Language
import com.daniily000.kodeprojectfour.data.Paradigm
import com.daniily000.kodeprojectfour.view.LanguageAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var mCurrentLanguagesList: MutableList<Language>

    private lateinit var mLanguages: List<Language>

    companion object {
        private const val SPAN_COUNT = 1
        private const val SEARCH_BAR_STATE_VISIBILITY = "search_bar_visibility"
        private const val SEARCH_BAR_STATE_TEXT = "search_bar_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initLanguagesList()

        languages_list.layoutManager = GridLayoutManager(this, SPAN_COUNT)
        languages_list.adapter = LanguageAdapter(mCurrentLanguagesList).also {
            it.listener = { language ->
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
                mLanguages.forEach {
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

    private fun initLanguagesList() {

        val objectOrientedParadigm = Paradigm(getString(R.string.paradigm_object_oriented))
        val structuredParadigm = Paradigm(getString(R.string.paradigm_structured))
        val imperativeParadigm = Paradigm(getString(R.string.paradigm_imperative))
        val genericParadigm = Paradigm(getString(R.string.paradigm_generic))
        val reflectiveParadigm = Paradigm(getString(R.string.paradigm_reflective))
        val concurrentParadigm = Paradigm(getString(R.string.paradigm_concurrent))
        val functionalParadigm = Paradigm(getString(R.string.paradigm_functional))
        val proceduralParadigm = Paradigm(getString(R.string.paradigm_procedural))
        val eventDrivenParadigm = Paradigm(getString(R.string.paradigm_event_driven))
        val declarativeParadigm = Paradigm(getString(R.string.paradigm_declarative))
        val taskDrivenParadigm = Paradigm(getString(R.string.paradigm_task_driven))

        val jamesGoslingAuthor = Author(getString(R.string.author_james_gosling))
        val dennisRitchieAuthor = Author(getString(R.string.author_dennis_ritchie))
        val guidoVanRossumAuthor = Author(getString(R.string.author_guido_van_rossum))
        val bjarneStroustrapAuthor = Author(getString(R.string.author_bjarne_stroustrup))
        val microsoftAuthor = Author(getString(R.string.author_microsoft))
        val brendanEichAuthor = Author(getString(R.string.author_brendan_eich))
        val rasmusLerdorfAuthor = Author(getString(R.string.author_rasmus_lerdorf))
        val donaldDChamberlinAuthor = Author(getString(R.string.author_donald_d_chamberlin))
        val raymondFBoyceAuthor = Author(getString(R.string.author_raymond_f_boyce))
        val tomLoveAuthor = Author(getString(R.string.author_tom_love))
        val bradCoxAuthor = Author(getString(R.string.author_brad_cox))

        val JAVA = Language(
            "Java",
            setOf(jamesGoslingAuthor),
            "1995",
            setOf(
                objectOrientedParadigm,
                structuredParadigm,
                imperativeParadigm,
                genericParadigm,
                reflectiveParadigm,
                concurrentParadigm
            ),
            15.932,
            URL("https://en.wikipedia.org/wiki/Java_(programming_language)"),
            R.mipmap.bitmap_java
        )

        val C = Language(
            "C",
            setOf(dennisRitchieAuthor),
            "1973",
            setOf(
                imperativeParadigm,
                structuredParadigm
            ),
            14.282,
            URL("https://en.wikipedia.org/wiki/C_(programming_language)"),
            R.mipmap.bitmap_c
        )

        val PYTHON = Language(
            "Python",
            setOf(guidoVanRossumAuthor),
            "1991",
            setOf(
                functionalParadigm,
                imperativeParadigm,
                objectOrientedParadigm,
                reflectiveParadigm
            ),
            8.376,
            URL("https://en.wikipedia.org/wiki/Python_(programming_language)"),
            R.mipmap.bitmap_python
        )

        val CPP = Language(
            "C++",
            setOf(bjarneStroustrapAuthor),
            "1985",
            setOf(
                proceduralParadigm,
                functionalParadigm,
                objectOrientedParadigm,
                genericParadigm
            ),
            7.562,
            URL("https://en.wikipedia.org/wiki/C%2B%2B"),
            R.mipmap.bitmap_cpp
        )

        val VBNET = Language(
            "Visual Basic .NET",
            setOf(microsoftAuthor),
            "2002",
            setOf(
                structuredParadigm,
                imperativeParadigm,
                objectOrientedParadigm,
                declarativeParadigm,
                genericParadigm,
                reflectiveParadigm,
                eventDrivenParadigm
            ),
            7.127,
            URL("https://en.wikipedia.org/wiki/Visual_Basic_.NET"),
            R.mipmap.bitmap_vbnet
        )

        val C_SHARP = Language(
            "C#",
            setOf(microsoftAuthor),
            "1998-2001",
            setOf(
                structuredParadigm,
                imperativeParadigm,
                objectOrientedParadigm,
                eventDrivenParadigm,
                taskDrivenParadigm,
                functionalParadigm,
                genericParadigm,
                reflectiveParadigm,
                concurrentParadigm
            ),
            3.455,
            URL("https://en.wikipedia.org/wiki/C_Sharp_(programming_language)"),
            R.mipmap.bitmap_csharp
        )

        val JAVA_SCRIPT = Language(
            "JavaScript",
            setOf(brendanEichAuthor),
            "1995",
            setOf(
                eventDrivenParadigm,
                functionalParadigm,
                imperativeParadigm,
                objectOrientedParadigm
            ),
            3.063,
            URL("https://en.wikipedia.org/wiki/JavaScript"),
            R.mipmap.bitmap_java_script
        )

        val PHP = Language(
            "PHP",
            setOf(rasmusLerdorfAuthor),
            "1994",
            setOf(
                imperativeParadigm,
                functionalParadigm,
                objectOrientedParadigm,
                proceduralParadigm,
                reflectiveParadigm
            ),
            2.442,
            URL("https://en.wikipedia.org/wiki/PHP"),
            R.mipmap.bitmap_php
        )

        val SQL = Language(
            "SQL",
            setOf(
                donaldDChamberlinAuthor,
                raymondFBoyceAuthor
            ),
            "1986",
            setOf(declarativeParadigm),
            2.184,
            URL("https://en.wikipedia.org/wiki/C_(programming_language)"),
            R.mipmap.bitmap_sql
        )

        val OBJECTIVE_C = Language(
            "Objective-C",
            setOf(
                tomLoveAuthor,
                bradCoxAuthor
            ),
            "early 1980s",
            setOf(
                imperativeParadigm,
                structuredParadigm
            ),
            1.781,
            URL("https://en.wikipedia.org/wiki/C_(programming_language)"),
            R.mipmap.bitmap_objective_c
        )

        mLanguages = listOf(
            JAVA,
            C,
            PYTHON,
            CPP,
            VBNET,
            C_SHARP,
            JAVA_SCRIPT,
            PHP,
            SQL,
            OBJECTIVE_C
        )

        mCurrentLanguagesList = mLanguages.toMutableList()
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
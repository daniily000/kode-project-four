package com.daniily000.kodeprojectfour

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.daniily000.kodeprojectfour.data.Language
import com.daniily000.kodeprojectfour.data.Languages
import com.daniily000.kodeprojectfour.view.LanguageAdapter
import org.junit.Assert.assertEquals
import org.junit.Test
import com.daniily000.kodeprojectfour.view.LanguageAdapter.*

class LanguagesUnitTest {

    @Test
    fun showLanguages() {
        for (language in Languages.list)
            println(language)
    }

    @Test
    fun assertLanguageEquals() {
        assertEquals(Languages.JAVA, Languages.list[0])
    }

    @Test
    fun showLanguageNames() {
        for (language in Languages.list) println(language.name)
    }

    @Test
    fun showLanguageBitmapResourceNames() {
        for (language in Languages.list) println(language.xmlName)
    }

}
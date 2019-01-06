package com.daniily000.kodeprojectfour

import com.daniily000.kodeprojectfour.data.Languages
import org.junit.Assert.assertEquals
import org.junit.Test

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
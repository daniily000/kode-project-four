package com.daniily000.kodeprojectfour.data

import android.util.Log
import java.net.URL
import java.util.*

data class Language(
    val name: String,
    val authors: Set<Author>,
    val releaseYear: String,
    val paradigms: Set<Paradigm>,
    val tiobeIndex: Double,
    val infoPage: URL,
    val xmlName: String
) {

    /**
     * Returns authors as a readable string
     */
    fun authors(): String =
        Arrays.toString(this.authors.toTypedArray())
            .replace("[", "")
            .replace("]", "")

    /**
     * Returns paradigms as a readable string
     */
    fun paradigms(): String =
        Arrays.toString(this.paradigms.toTypedArray())
            .replace("[", "")
            .replace("]", "")

    fun searchParadigms(vararg keywords: String): Boolean {
        Log.d(TAG, "Searching in ${paradigms()}")

        for (keyword in keywords) {

            Log.d(TAG, "keyword=$keyword")
            var paradigmFound = false
            for (paradigm in paradigms) {
                Log.d(TAG, "paradigm=$paradigm")
                paradigmFound = paradigmFound or paradigm.toString().contains(keyword, true)
                Log.d(TAG, "paradigmFound=$paradigmFound\n")
                if (paradigmFound) break
            }
            if (!paradigmFound) return false

        }
        return true
    }

    companion object {
        private const val TAG = "Language"
    }
}
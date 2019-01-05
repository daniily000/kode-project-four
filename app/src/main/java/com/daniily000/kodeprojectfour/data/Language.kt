package com.daniily000.kodeprojectfour.data

import java.net.URL
import java.util.*

data class Language(
    val name: String,
    val authors: Set<Author>,
    val releaseYear: String,
    val paradigms: Set<Paradigm>,
    val tiobeIndex: Double,
    val infoPage: URL,
    val xmlName: String) {

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
}
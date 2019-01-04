package com.daniily000.kodeprojectfour.data

import java.net.URL

data class Language(
    val name: String,
    val authors: Set<Author>,
    val releaseYear: String,
    val paradigms: Set<Paradigm>,
    val tiobeIndex: Double,
    val infoPage: URL)
package com.daniily000.kodeprojectfour.data

/**
 * Represents an information about an author
 */
data class Author(val name: String, val surname: String? = null) {

    override fun toString(): String {
        return name + if (surname != null) " $surname" else ""
    }
}
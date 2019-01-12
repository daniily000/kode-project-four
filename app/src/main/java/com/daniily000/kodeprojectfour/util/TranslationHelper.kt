package com.daniily000.kodeprojectfour.util

import android.content.res.Resources
import com.daniily000.kodeprojectfour.R

class TranslationHelper(private val resources: Resources) {

    fun translateByName(resourceName: String): String? = try {
        resources.getString(findResourceIdByName(R.string::class.java, resourceName))
    } catch (e: NoSuchFieldException) {
        null
    }


    @Throws(NoSuchFieldException::class)
    private fun findResourceIdByName(`class`: Class<*>, name: String) =
        `class`.getDeclaredField(name).getInt(null)


}
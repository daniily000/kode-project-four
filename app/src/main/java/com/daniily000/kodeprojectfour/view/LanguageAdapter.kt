package com.daniily000.kodeprojectfour.view

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daniily000.kodeprojectfour.R
import com.daniily000.kodeprojectfour.data.Language
import kotlinx.android.synthetic.main.language_item.view.*

/**
 * Adapts given Language data array to become a view to display
 */
class LanguageAdapter(private val languages: List<Language>) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    var listener: ((language: Language) -> Unit)? = null


    /**
     * Initializes a view with no data
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LanguageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.language_item,
                    parent,
                    false
                )
        )

    /**
     * Gives the count of items to display
     */
    override fun getItemCount(): Int = languages.size

    /**
     * Fills a view with new data
     */
    // TODO Add proper localized searching bar
    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val lang = languages[position]
        holder.mView.apply {

            language_src.setImageBitmap(lang.bitmap(holder.mView.context.resources))
            language_name.text = lang.name
            authors.text = lang.authors()
            release_year.text = lang.releaseYear
            paradigms.text = lang.paradigms()
            tiobe.text = String.format("%.3f%%", lang.tiobeIndex)
            setOnClickListener { listener?.invoke(lang) }
        }
    }

    /**
     * Just stores a view to display
     */
    class LanguageViewHolder(internal val mView: View) : RecyclerView.ViewHolder(mView)

    /**
     * Searches for a bitmap with name "bitmap_${language.xmlName.toLowerCase()}" from mipmap dir for
     * a language. Returns null if not found
     */
    private fun Language.bitmap(resources: Resources): Bitmap? {
        return try {
            if (id != null) {
                BitmapFactory.decodeResource(resources, this.id)
            } else {
                null
            }
        } catch (e: NoSuchFieldException) {
            null
        } catch (e: ClassCastException) {
            null
        }
    }


//    private fun Author.translate(translationHelper: TranslationHelper): String {
//        return translationHelper.translateByName("author_${this.xmlName}")?:this.toString()
//    }
//
//    private fun Paradigm.translate(translationHelper: TranslationHelper): String {
//        return translationHelper.translateByName("paradigm_${this.xmlName}") ?: this.toString()
//    }
}
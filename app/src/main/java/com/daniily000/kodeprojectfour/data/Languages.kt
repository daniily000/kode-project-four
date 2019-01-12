package com.daniily000.kodeprojectfour.data

import com.daniily000.kodeprojectfour.data.Languages.Creator.authors
import com.daniily000.kodeprojectfour.data.Languages.Creator.paradigms
import com.daniily000.kodeprojectfour.data.Paradigm.*
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

object Languages {

    val list: List<Language>

    val JAVA = Language(
        "Java",
        authors(Author("James", "Gosling", "james_gosling")),
        "1995",
        paradigms(OBJECT_ORIENTED, STRUCTURED, IMPERATIVE, GENERIC, REFLECTIVE, CONCURRENT),
        15.932,
        URL("https://en.wikipedia.org/wiki/Java_(programming_language)"),
        "java"
    )

    val C = Language(
        "C",
        authors(Author("Dennis", "Ritchie", "dennis_ritchie")),
        "1973",
        paradigms(IMPERATIVE, STRUCTURED),
        14.282,
        URL("https://en.wikipedia.org/wiki/C_(programming_language)"),
        "c"
    )

    val PYTHON = Language(
        "Python",
        authors(Author("Guido", "van Rossum", "guido_van_rossum")),
        "1991",
        paradigms(FUNCTIONAL, IMPERATIVE, OBJECT_ORIENTED, REFLECTIVE),
        8.376,
        URL("https://en.wikipedia.org/wiki/Python_(programming_language)"),
        "python"
    )

    val CPP = Language(
        "C++",
        authors(Author("Bjarne", "Stroustrup", "bjarne_stroustrup")),
        "1985",
        paradigms(PROCEDURAL, FUNCTIONAL, OBJECT_ORIENTED, GENERIC),
        7.562,
        URL("https://en.wikipedia.org/wiki/C%2B%2B"),
        "cpp"
    )

    val VBNET = Language(
        "Visual Basic .NET",
        authors(Author("Microsoft", xmlName = "microsoft")),
        "2002",
        paradigms(
            STRUCTURED,
            IMPERATIVE,
            OBJECT_ORIENTED,
            DECLARATIVE,
            GENERIC,
            REFLECTIVE,
            EVENT_DRIVEN
        ),
        7.127,
        URL("https://en.wikipedia.org/wiki/Visual_Basic_.NET"),
        "vbnet"
    )

    val C_SHARP = Language(
        "C#",
        authors(Author("Microsoft", xmlName = "microsoft")),
        "1998-2001",
        paradigms(
            STRUCTURED,
            IMPERATIVE,
            OBJECT_ORIENTED,
            EVENT_DRIVEN,
            TASK_DRIVEN,
            FUNCTIONAL,
            GENERIC,
            REFLECTIVE,
            CONCURRENT
        ),
        3.455,
        URL("https://en.wikipedia.org/wiki/C_Sharp_(programming_language)"),
        "csharp"
    )

    val JAVA_SCRIPT = Language(
        "JavaScript",
        authors(Author("Brendan", "Eich", "brendan_eich")),
        "1995",
        paradigms(EVENT_DRIVEN, FUNCTIONAL, IMPERATIVE, OBJECT_ORIENTED),
        3.063,
        URL("https://en.wikipedia.org/wiki/JavaScript"),
        "java_script"
    )

    val PHP = Language(
        "PHP",
        authors(Author("Rasmus", "Lerdorf", "rasmus_lerdorf")),
        "1994",
        paradigms(IMPERATIVE, FUNCTIONAL, OBJECT_ORIENTED, PROCEDURAL, REFLECTIVE),
        2.442,
        URL("https://en.wikipedia.org/wiki/PHP"),
        "php"
    )

    val SQL = Language(
        "SQL",
        authors(Author("Donald", "D. Chamberlin", "donald_d_chamberlin"), Author("Raymond", "F. Boyce", "raymond_f_boyce")),
        "1986",
        paradigms(DECLARATIVE),
        2.184,
        URL("https://en.wikipedia.org/wiki/C_(programming_language)"),
        "sql"
    )

    val OBJECTIVE_C = Language(
        "Objective-C",
        authors(Author("Tom", "Love", "tom_love"), Author("Brad", "Cox", "brad_cox")),
        "early 1980s",
        paradigms(IMPERATIVE, STRUCTURED),
        1.781,
        URL("https://en.wikipedia.org/wiki/C_(programming_language)"),
        "objective_c"
    )

    init {
        list = Collections.unmodifiableList(
            ArrayList<Language>().apply {
                add(JAVA)
                add(C)
                add(PYTHON)
                add(CPP)
                add(VBNET)
                add(C_SHARP)
                add(JAVA_SCRIPT)
                add(PHP)
                add(SQL)
                add(OBJECTIVE_C)
            })
    }

    object Creator {
        fun <E> authors(vararg o: E): Set<E> {
            val set = HashSet<E>()
            for (e in o) set.add(e)
            return Collections.unmodifiableSet(set)
        }

        fun <E> paradigms(vararg o: E) = authors(*o)
    }
}
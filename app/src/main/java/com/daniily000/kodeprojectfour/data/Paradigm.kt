package com.daniily000.kodeprojectfour.data

enum class Paradigm {

    OBJECT_ORIENTED,
    STRUCTURED,
    IMPERATIVE,
    GENERIC,
    REFLECTIVE,
    CONCURRENT,
    FUNCTIONAL,
    PROCEDURAL,
    EVENT_DRIVEN,
    DECLARATIVE,
    TASK_DRIVEN;

    override fun toString(): String {
        return this.name.toLowerCase().capitalize().replace('_', '-')
    }
}
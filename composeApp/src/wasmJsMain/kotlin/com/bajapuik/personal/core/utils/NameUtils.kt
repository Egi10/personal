package com.bajapuik.personal.core.utils

object NameUtils {
    fun getInitials(name: String): String {
        return name
            .split(" ")
            .filter {
                it.isNotBlank()
            }.joinToString("") {
                it.firstOrNull()?.uppercase() ?: ""
            }
    }
}
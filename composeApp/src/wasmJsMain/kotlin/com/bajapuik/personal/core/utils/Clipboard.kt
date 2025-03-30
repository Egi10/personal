package com.bajapuik.personal.core.utils

import kotlinx.browser.window
import org.w3c.dom.clipboard.Clipboard

object Clipboard {
    fun copy(text: String) {
        val clipboard: Clipboard = window.navigator.clipboard
        clipboard.writeText(text)
    }
}
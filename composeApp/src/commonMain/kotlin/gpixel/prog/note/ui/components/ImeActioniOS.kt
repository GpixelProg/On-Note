package gpixel.prog.note.ui.components

import androidx.compose.runtime.MutableState

/**
 * TODO Ime Action on iOS is not working yet but
 * working other features like keyboard type '\n'
 */
fun returnImeAction(value: MutableState<String>, content: () -> Unit) {
    if (value.value.last() == '\n') {
        value.value = value.value.dropLast(1)
        content()
    }
}
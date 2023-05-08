package gpixel.prog.note.view_models

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import gpixel.prog.note.ui.CreateAccount
import gpixel.prog.note.ui.Login

class PreviewModel(private val navigator: Navigator) : ScreenModel {
    fun createAccount() {
        navigator.push(CreateAccount)
    }

    fun onLogin() {
        navigator.push(Login)
    }
}
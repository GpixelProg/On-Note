package gpixel.prog.note.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import gpixel.prog.note.ui.Login

class CreateAccountModel(private val navigator: Navigator) : ScreenModel {

    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var confirmPassword = mutableStateOf("")
    var errorMsg by mutableStateOf("")

    fun createAccount() {
        errorMsg = if (password.value != confirmPassword.value) {
            "Passwords don't match"
        } else if (email.value.isEmpty() || password.value.isEmpty() || confirmPassword.value.isEmpty()) {
            "Please fill in all fields"
        } else {
            ""
        }
    }

    fun onLogin() {
        navigator.push(Login)
    }
}
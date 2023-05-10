package gpixel.prog.note.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel

class CreateAccountModel : ScreenModel {

    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var confirmPassword = mutableStateOf("")
    var errorMsg by mutableStateOf("")

    fun createAccount() {
        if (password.value != confirmPassword.value) {
            errorMsg = "Passwords don't match"
        }
    }
}